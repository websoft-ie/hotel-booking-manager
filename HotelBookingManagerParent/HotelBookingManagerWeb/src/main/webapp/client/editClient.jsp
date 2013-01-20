<%--
    Document   : editClient
    Created on : Nov 24, 2012, 10:31:07 PM
    Author     : Andrej Galád
--%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:message var="pageTitle" key="client.pageTitle"/>
<s:layout-render name="/layout.jsp" title= "${pageTitle}" pageInfo="client.jsp">
    <s:layout-component name="right_content">
       <s:useActionBean beanclass="cz.fi.muni.pa165.hotelbookingmanagerweb.ClientsActionBean" var="actionBean"/>

            <div class="content_right_section">
                <div class="content_title_02"><fmt:message key="changeClient"/></div>
                <p><fmt:message key="changeClientDescription"/></p>

                <div class="cleaner">&nbsp;</div>
            </div>

            <div class="cleaner_h40">&nbsp;</div>

            <s:form beanclass="cz.fi.muni.pa165.hotelbookingmanagerweb.ClientsActionBean">
                <div class="content_right_section">
                    <div class="content_title_02"><fmt:message key="attributesClient"/> ${actionBean.client.firstName} ${actionBean.client.lastName}: </div>

                        <s:hidden name="client.id"/>
                        <%@include file="formClient.jsp"%>
                        <div class="cleaner_h20">&nbsp;</div>

                    <div class="cleaner">&nbsp;</div>
                </div> <!-- end of editing -->

                <div class="content_right_2column_box">
                    <s:submit name="save"/>
                    <div class="cleaner_h10">&nbsp;</div>
                </div>

                <div class="content_right_2column_box">
                    <s:submit name="clientAll"/>
                    <div class="cleaner_h10">&nbsp;</div>
                </div>
            </s:form>

    </s:layout-component>
</s:layout-render>
