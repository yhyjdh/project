<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<p><span><strong>총 ${comment.totalCount}개</strong>  |  ${commentVO.page}/ ${comment.totalPage}페이지</span></p>
<table class="list">
    <colgroup>
        <col width="80px" />
        <col width="*" />
        <col width="100px" />
        <col width="200px" />
    </colgroup>
 
    <tbody>
    <c:if test="${empty comment.list}">
        <tr>
            <td class="first" colspan="8">등록된 댓글이 없습니다.</td>
        </tr>
    </c:if>
    <c:forEach var="vo" items="${comment.list}">                                     
        <tr>
            <td>${vo.no}</td>
            <td class="txt_l" style="text-align:left;">												 <!-- 댓글번호  -->
                ${vo.content}<c:if test="${loginInfo.no == vo.member_no}"><a href="javascript:commentDel(${vo.no});"> &nbsp;&nbsp;[삭제]</a></c:if>
            </td>
            <td class="writer">
                ${vo.member_name}
            </td>
            <td class="date"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${vo.regdate}"/></td>
        </tr>
    </c:forEach>    
    </tbody>
</table>
<div class="pagenate clear">
	<ul class='paging'>
		<c:if test="${comment.prev == true}">
			<li><a href="javascript:getComment(${comment.startPage});"><</a></li>
		</c:if>		<!-- start->endpage 변수  -->
		<c:forEach var="p" begin="${comment.startPage}" end="${comment.endPage}">
			<li><a href="javascript:getComment(${p});" <c:if test="${commentVO.page == p}"> class='current'</c:if>>${p}</a></li>
		</c:forEach>
		<c:if test="${data.next == true}">
			<li><a href="javascript:getComment(${comment.endPage+1});">></a></li>
		</c:if>
	</ul> 
</div>