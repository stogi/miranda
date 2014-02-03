<%@ page import="org.springframework.validation.FieldError" %>

<g:set var="entityName" value="${message(code: 'tvShow.label')}"/>

<html>
<head>
    <meta name="layout" content="main">

    <title><g:message code="default.${mode}.label" args="[entityName]"/></title>
</head>

<body>
    <h2><g:message code="default.${mode}.label" args="[entityName]"/></h2>

    <g:hasErrors bean="${tvShow}">
        <div class="alert alert-danger">
            <g:eachError bean="${tvShow}" var="error">
                <p ${error in FieldError ? "data-field-id=\"${error.field}\"" : ''}><g:message error="${error}"/></p>
            </g:eachError>
        </div>
    </g:hasErrors>  

    <form action="${createLink(action: 'save', id: tvShow?.id)}" method="post" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">
                <g:message code="tvShow.name.label"/>
            </label>
            <div class="col-sm-10">
                <input id="name" name="name" type="text" placeholder="Name" value="${tvShow?.name}" autofocus class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">
                    <g:message code="default.button.${mode}.label"/>
                </button>
                <a href="${createLink(action: 'index')}" class="btn btn-default">
                    <g:message code="default.button.cancel.label"/>
                </a>
            </div>
        </div>
    </form>
</body>
</html>
