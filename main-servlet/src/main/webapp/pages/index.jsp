<jsp:useBean id="testBean" class="com.webarity.models.Thing" scope="session" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="https://www.webarity.com/tlib/blabla" prefix="ctt" %>

<%@ taglib tagdir="/WEB-INF/tags/" prefix="ct" %>

<h1>TEST</h1>
<p>prop: ${testBean.propB}</p>
<c:if test="${testBean.propB == 0}">
    <p>initializing val...</p>
    <jsp:setProperty name="testBean" property="propB" value="${System.currentTimeMillis()}" />
</c:if>

<div>
    <ct:firstTestTag attrA="aaa" attrB="bbb" attrC="ccc"/>
</div>

<ctt:customTestTag />