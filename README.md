## 文档

### 微服务模块

- qingpu-auth 认证授权模块
- qingpu-gateway 网关模块
- qingpu-common 通用模块
- qingpu-common-service 通用服务模块
- qingpu-user 用户模块
- qingpu-exchange 交易所模块
- qingpu-elasticsearch 搜索引擎模块
- qingpu-binance 币安交易所模块

### 接口划分

- 认证授权模块接口
  - 获取token
  - 刷新token
  - 获取令牌
  - 手机验证码
  - 邮箱验证码
- 用户模块接口
  - 用户信息
  - 更新用户信息
  - 更新头像
  - 创建账户
  - 关注用户
  - 获取关注列表
  - 取消关注
  - 更新手机
  - 更新邮箱
  - 发送验证码到已绑定的邮箱
  - 发送验证码到已绑定的手机
  - 校验密码
  - 用户交易所账号信息
- 通用服务模块
  - 发送手机验证码
  - 发送邮箱验证码
- 交易所模块接口
  - 获取支持的数字货币交易所
  - 获取数字货币交易所账号信息
  - 添加数字货币交易所账号信息
  - 更新数字货币交易所账号信息
  - 删除数字货币交易所账号信息
- 币安模块
  - 订单测试


### 业务逻辑

- 更新手机/邮箱

<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/qRCnWPxh/Snipaste-2022-11-14-16-22-20.png' border='0' alt='image'/></a>

- 绑定手机/邮箱

<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/RVKhghcd/image.png' border='0' alt='image'/></a>







```bash
#########1、新增用户信息（考虑各种用户信息，至少包含用户名，密码，UID，初始用户组）##########
function groupAddSetGID()
{
echo "define GID? input 1  undefine GID input other"
read -p ":" choose
if [ $choose -eq 1 ] #choose is option 
then
      control=1
      while  [ $control -eq 1 ]
          do
          read -p "please input group name：" hello
          group=$hello
          id -g $group >/dev/null 2>&1 #judge if the group is exist
          if [ "$?" == "0" ]; then
          echo "user $group already exist." #group is exist reinput 
          else
              while [ $control -eq 1 ] #group is not exist execute the groupadd command 
	      do

	      declare -i GID
              read -p "please input GID:" GID  #input group GID 
	      id -g $GID >/dev/null 2>&1   # judge if the group GID is exist
	          if [ "$?" == "0" ] 
		  then
                  echo "user $GID already exist." # GID is exist reinput angian
                  else                             # GID is not exist execute command
	         	control=0	      
                  fi
              done
	  fi
    done
          groupadd -g $GID $group
	  if [ $? -eq 0 ]
          then 
		  echo "created successfully"
		  cat /etc/group |grep $group
          else echo "created fail"
          fi
    else
	    control=1
      while  [ $control -eq 1 ]
          do
          read -p "please input group name：" hello
          group=$hello
          id -g $group >/dev/null 2>&1
          if [ "$?" == "0" ]; then
          echo "user $group already exist."
          else
               groupadd  $group
	       if [ $? -eq 0 ]
               then
                  echo "created successfully"
                 cat /etc/group |grep $group
               else echo "created fail"
               fi

	       control=0
	  fi
          done
fi 
}
#########2、修改用户信息（要求同上）##########
function updateGroupNameAndGID()
{   
echo "change groupName? input 1  change GID input other"
read -p ":" choose
if [ $choose == 1 ]
then      
	  read -p "please input original name:" original #original  groupname
          group=$orignial
          read -p "please input changed name:" change
          group=$change
   groupmod -n $change $original
   cat /etc/group |grep $change
   else  
          control=1
          while  [ $control -eq 1 ]
              do
              read -p "please input the group name that you want to change:" groupname
              group=$groupname
              id -g $groupname >/dev/null 2>&1
              if [ "$?" == "0" ]
              then
		      break
              #echo "group name is not exist please reinput"  
              else  control=0

              fi
          done
	  control=1
	   while [ $control -eq 1 ]
              do

              declare -i GID
              read -p "please input GID:" GID
              id -g $GID >/dev/null 2>&1
                  if [ "$?" == "0" ]
                  then
                  echo "user $GID already exist. please reinput"
                  else
                        groupmod -g $GID $groupname
                        control=0
                  fi
              done
          cat /etc/group |grep  $groupname
fi
}
#########4、删除用户（考虑是否连带删除用户家目录情况）##########
function deleteGroup()
{
          read -p "please input the group name that you want to delete:" deleteGroupName
          groupdel -f $deleteGroupName | echo "delete sucess"	  
}
function checkUserGroup()
{           
      echo " you want to check a single group or all group,input 1 single,0 all"
      read -p ":" choose
      if [ $choose == 1 ]
       then

            control=1
              while  [ $control -eq 1 ]
              do
              read -p "please input the groupname that you want to check:" group
              id -g $group >/dev/null 2>&1
              if [ "$?" == "0" ]
              then
	      control=0
              else cat /etc/group |grep $group
		      control=0    
	      fi
              done
      else 
	      cat /etc/group
      fi
}

#######5.新增用户组信息#########
function addSingleUser() 
{  #生成单个用输入形式
    	control=1
       	while [ $control -eq 1 ]
	do
       	declare -i U
	read -p "please input name:" name
	read -p "plese input UID number:" U
	read -p "please input passwd:" Passwd
	id -u $name >/dev/null 2>&1 
	if [ "$?" == "0" ]
	then
		echo "user already exist."
	else 	
	useradd -u $U -d /home/$name -s /bin/bash -g root  $name
	echo ${name}:$Passwd > chpass1.txt
	chpasswd < chpass1.txt  # 直接修改密码的命令 格式是    用户名：密码
	control=0
	echo "successfully created!"
	cat /etc/passwd |grep $name
	fi
done
}
#######6.修改用户组信息（可修改GID、用户组名）#########
function changeSingleUserInfo()
{               
                echo "1 update username"
                echo "2 update passwd"
                echo "3 update UID"
                echo "4 update GID"
                read -p "please input number: " number
                if [ $number -eq 1 ]
                then
                        read -p "Please input old username:" oldname
                        read -p "Please input new username:" username
                        usermod -l $username $oldname
                        echo "update success!"
			cat /etc/passwd |grep $username
                elif [ $number -eq 2 ]
                then
                        read -p "Please input username you want to update:" opasswd
                        read -p "Please input new passwd:" npasswd
                        echo "$opasswd:$npasswd"| chpasswd
                        echo "update success!"
			cat /etc/shadow |grep $opasswd
                elif [ $number -eq 3 ]
                then
                        read -p "Please input username you want to update:" oUID
                        read -p "Please input new UID:" nUID
                        usermod -u $nUID $oUID
                        echo "update success!"
			cat /etc/passwd |grep $oUID
                elif [ $number -eq 4 ]
                then
                        read -p "Please input username you want to update:" oGID
                        read -p "Please input new GID:" nGID
                        usermod -g $nGID $oGID
                        echo "update success!"
                else echo "input error"
                fi

}
#####7.删除用户组#######
function deleteSingleUser(){
                        read -p "Please input the user's  name you want to delete: " user2
                        grep "$user2" /etc/passwd >/dev/null
                        if [ $? -eq 0 ]
                        then
                                
                                read -p "Do you want delete dir?(y input 1/n input 2:)" sel
                                if [ $sel -eq 1 ]
                                then
                                userdel  $user2 
				rm -f /home/$user2
                                elif [ $sel -eq 2 ]
                                then
				userdel $user2 
		         	else
		 	        echo "input error"	
                                fi
				echo "deleted successfully"
                        else
                                echo "The user does not exist!"
                        fi
}
#####8.列出用户组信息#######
function CheckUserInfo(){     
                                echo "input 1 find a single user or input other check all users"
				read -p "input:" choose
			 if [ $choose -eq 1 ]
				then
                                read -p "Please input the user's name you want to find: " user3
                                grep -n "$user3" /etc/passwd
                                if [ $? -eq 1 ]
                                then
                                        echo "The user does not exist!"
                                fi
		        else cat /etc/passwd
			fi
}
#####9.提供菜单界面供用户进行功能选择#######
function menu()
{
echo "##########################################"
echo "welcome to the system of user management"
echo "please input number 1-8"
echo "0.  exit"
echo "1.  add Single User "
echo "2.  update Single User Infomation"
echo "3.  delete Single User "
echo "4.  Check User Infomation"
echo "5.  add  group and add set GID"
echo "6.  update GroupName And GID"
echo "7.  deleteGroup"
echo "8.  check Group infomation"
echo "##########################################"
read -p "input:" number
while  [ $number -ne 0 ]
do
        if [ $number -eq 1 ]
        then
               addSingleUser
        elif [ $number -eq 2 ]
        then
          changeSingleUserInfo
        elif [ $number -eq 3 ]
        then 
          deleteSingleUser
        elif [ $number -eq 4 ]
        then
         CheckUserInfo
        elif [ $number -eq 5 ]
        then
                groupAddSetGID
        elif [ $number -eq 6 ]
        then
                updateGroupNameAndGID
        elif [ $number -eq 7 ]
        then
                deleteGroup
        elif  [ $number -eq 8 ]
        then
                checkUserGroup
        else echo "input error please reinput"
        fi
echo "##########################################"
echo "welcome to the system of user management"
echo "please input number 1-8"
echo "0.  exit"
echo "1.  add Single User "
echo "2.  update Single User Infomation"
echo "3.  delete Single User "
echo "4.  Check User Infomation"
echo "5.  add  group and add set GID"
echo "6.  update GroupName And GID"
echo "7.  deleteGroup"
echo "8.  check Group infomation"
echo "##########################################"

        echo "please input number 1-8"
        read -p "input:" number
done
}
menu
```

