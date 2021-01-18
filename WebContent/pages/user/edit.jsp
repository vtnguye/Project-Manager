<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-sm-6">
		<form:form id="editForm" method="post" modelAttribute="o"
			data-parsley-validate="data-parsley-validate">
			<%-- <div class="form-group row">
        <label class="form-control-label col-sm-3">Mã phòng ban<span class="required">(*)</span></label>
        <div class="col-sm-9">
          <form:input id="id" path="id" cssClass="form-control" required="required" />
          <form:errors id="error_id" path="id" cssStyle="color: #F00;" />
        </div>
      </div> --%>
			<div class="form-group row">
				<label class="form-control-label col-sm-3">Tên người dùng<span
					class="required">(*)</span></label>
				<div class="col-sm-9">
					<form:input type="name" id="username" path="username" value="${o.username}"
						cssClass="form-control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label class="form-control-label col-sm-3">Mật khẩu<span
					class="required">(*)</span></label>
				<div class="col-sm-9">
					<form:input type="password" id="password" path="password" value="${o.password}"
						cssClass="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="form-control-label col-sm-3">Mã nhân viên<span
					class="required">(*)</span></label>
				<div class="col-sm-9">
					<form:select id="employeeId" cssClass="form-control"
						required="required" path="employeeId" value="${o.employeeId}">
						<form:option value="">--Chọn nhân viên--</form:option>
						<form:options required="required" items="${map}" />
					</form:select>
				</div>
			</div>
			<div class="ln_solid"></div>
			<div class="form-group row">
				<div class="col-sm-8 col-sm-offset-1">
					<button type="submit" class="btn btn-primary" style="width: 100px;"
						id="btnSave">Thay đổi</button>
					<button type="button" onclick="location.href='${pageContext.request.contextPath}/pages/user/list.html'" class="btn btn-default">Hủy</button>
				</div>
			</div>
			<!-- hidden field -->
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<form:input type="hidden" id="date" path="activeDate"
				value="${o.activeDate}" cssClass="form-control" />
			<input type="hidden" name="crudaction" value="insert-update" />
		</form:form>
	</div>
</div>