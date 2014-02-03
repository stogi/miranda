<%@ page import="com.stogiapps.miranda.TvShow" %>

<g:set var="entityName" value="${message(code: 'tvShow.label')}"/>

<html>
<head>
    <meta name="layout" content="main">

    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
    <h2><g:message code="default.list.label" args="[entityName]"/></h2>

    <g:if test="${flash.message}">
        <div class="alert alert-info">${message(flash.message)}</div>
    </g:if>

    <p>
        <a href="${createLink(action: 'add')}" class="btn btn-primary" tabindex="0">
            <i class="glyphicon glyphicon-plus"></i>
            <g:message code="default.button.add.label"/>
        </a>
    </p>

    <section class="table-responsive">
        <table class="table table-condensed">
            <thead>
                <tr>
                    <th><g:message code="tvShow.name.label"/></th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${tvShows}" status="i" var="tvShow">
                    <tr>
                        <td>${tvShow.name}</td>
                        <td>
                            <a href="${createLink(action: 'edit', id: tvShow.id)}" class="btn btn-primary btn-xs">
                                <i class="glyphicon glyphicon-edit"></i>
                            </a>
                            <a href="${createLink(action: 'delete', id: tvShow.id)}" class="btn btn-danger btn-xs">
                                <i class="glyphicon glyphicon-trash"></i>
                            </a>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </section>
</body>
</html>
