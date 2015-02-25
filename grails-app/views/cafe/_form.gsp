<%@ page import="com.pangio.cafe.Cafe" %>



<div class="fieldcontain ${hasErrors(bean: cafeInstance, field: 'city', 'error')} required">
    <label for="city">
        <g:message code="cafe.city.label" default="City"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="city" required="" value="${cafeInstance?.city}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: cafeInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="cafe.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${cafeInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: cafeInstance, field: 'neighborhood', 'error')} required">
    <label for="neighborhood">
        <g:message code="cafe.neighborhood.label" default="Neighborhood"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="neighborhood" required="" value="${cafeInstance?.neighborhood}"/>

</div>

