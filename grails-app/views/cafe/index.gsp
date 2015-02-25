<%@ page import="com.pangio.cafe.Cafe" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'cafe.label', default: 'Cafe')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-cafe" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-cafe" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="city" title="${message(code: 'cafe.city.label', default: 'City')}"/>

            <g:sortableColumn property="id" title="${message(code: 'cafe.id.label', default: 'id')}"/>
            <g:sortableColumn property="name" title="${message(code: 'cafe.name.label', default: 'Name')}"/>

            <g:sortableColumn property="neighborhood"
                              title="${message(code: 'cafe.neighborhood.label', default: 'Neighborhood')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${cafeInstanceList}" status="i" var="cafeInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${cafeInstance.id}">${fieldValue(bean: cafeInstance, field: "city")}</g:link></td>

                <td>${fieldValue(bean: cafeInstance, field: "id")}</td>
                <td>${fieldValue(bean: cafeInstance, field: "name")}</td>

                <td>${fieldValue(bean: cafeInstance, field: "neighborhood")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${cafeInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
