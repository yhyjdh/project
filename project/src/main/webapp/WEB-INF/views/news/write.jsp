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
    <title>게시판 등록</title>
    <link rel="stylesheet" href="/project/css/reset.css"/>
    <link rel="stylesheet" href="/project/css/contents.css"/>
    <script>
		function goSave() {
			frm.submit();
		}
	</script>
</head>
<body>
    
    <div class="sub">
        <div class="size">
            <h3 class="sub_title">게시판</h3>

            <div class="bbs">
            <form method="post" name="frm" id="frm" action="insert.do" ><!-- enctype="multipart/form-data" -->
                <table class="board_write">
                    <tbody>
                    <tr>
                        <th>제목</th>
                        <td>
                            <input type="text" name="title" id="title" class="wid100" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td>
                            <textarea name="content" id="contents"></textarea>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btnSet"  style="text-align:right;">
                    <a class="btn" href="javascript:goSave();">저장 </a>
                </div>
                </form>
            </div>
        </div>
    </div>
        
</body>
</html>