<%@ tag dynamic-attributes="attrMap" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
<c:forEach var="attr" begin="0" items="${attrMap}">
    <li title="${attr.key}">${attr.key} = ${attr.value}</li> 
</c:forEach>
</ul>

