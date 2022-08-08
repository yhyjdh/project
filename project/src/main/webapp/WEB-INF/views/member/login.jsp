<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>로그인</title>
    <link rel="stylesheet" href="/project/css/reset.css"/>
    <link rel="stylesheet" href="/project/css/contents.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
    	function loginCheck1() {
    		if ($("#email1").val() == '') {
    			alert('이메일을 입력해 주세요');
    			$("#email1").focus();
    			return false;
    		}
    		if ($("#pwd1").val() == '') {
    			alert('비밀번호를 입력해 주세요');
    			$("#pwdl1").focus();
    			return false;
    		}
    		
    	}
    </script>
</head>
<body>    																	<!-- return => 안쓰면 false도 전송되므로 false리턴 안되게 -->
    <form action="login.do" method="post" id="loginFrm1" name=loginFrm1" onsubmit="return loginCheck1();"><!-- header에서 id="board"이미 사용중이라서 board2로 함 -->
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">로그인</h3>
                
                <div class="member">
                    <div class="box">
                        <fieldset class="login_form">
                            <ul>
                                <li><input type="text" id="email1" name="email" placeholder="이메일"></li>
                                <li><input type="password" id="pwd1" name="pwd" placeholder="비밀번호"></li>
                                <li><label><input type="checkbox" name="reg1" id="reg1"/> 아이디저장</label></li>
                            </ul>
                            <div class="login_btn"><input type="submit" value="로그인" alt="로그인" /></div>
                        </fieldset>
                        <div class="btnSet clear">
                            <div>
                                <a href="join.do" class="btn">회원가입</a> 
                                <a href="findEmail.do" class="btn">이메일/비밀번호 찾기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>        
</body>
</html>