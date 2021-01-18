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
				<label class="form-control-label col-sm-3">Tên nhân viên<span
					class="required">(*)</span></label>
				<div class="col-sm-9">
					<form:input type="name" id="name" path="fullName"
						value="${o.fullName}" cssClass="form-control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label class="form-control-label col-sm-3">Năm sinh<span
					class="required">(*)</span></label>
				<div class="col-sm-9">
					<form:input type="date" id="date" path="birthday"
						value="${o.birthday}" cssClass="form-control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label class="form-control-label col-sm-3">Email<span
					class="required">(*)</span></label>
				<div class="col-sm-9">
					<form:input type="email" id="email" path="email" value="${o.email}"
						cssClass="form-control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label class="form-control-label col-sm-3">Số điện thoại<span
					class="required">(*)</span></label>
				<div class="col-sm-9">
					<form:input type="number" id="phone" path="phone"
						value="${o.phone}" cssClass="form-control" required="required" />
				</div>
			</div>
			<div class="form-group row">
				<label class="form-control-label col-sm-3">Mã phòng ban<span
					class="required">(*)</span></label>
				<div class="col-sm-9">
					<form:select id="departmentId" cssClass="form-control"
						required="required" path="departmentId" value="${o.departmentId}">
						<form:option value="">--Chọn phòng ban--</form:option>
						<form:options required="required" items="${map}" />
					</form:select>
				</div>
			</div>
			<div class="ln_solid"></div>
			<div class="form-group row">
				<div class="col-sm-8 col-sm-offset-1">
					<button type="submit" class="btn btn-primary" style="width: 100px;"
						id="btnSave">Thay đổi</button>
					<button type="button" onclick="location.href='${pageContext.request.contextPath}/pages/employee/list.html'" class="btn btn-default">Hủy</button>
				</div>
			</div>
			<!-- hidden field -->
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<input type="hidden" name="crudaction" value="insert-update" />
		</form:form>
	</div>
</div>