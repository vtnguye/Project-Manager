<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<div class="account-bg">
  <div class="card-box m-b-0">
    <div class="text-xs-center m-t-20">
      <a href="index.html" class="logo"> 
        <img alt="logo" src='<c:url value="/images/logo.png"/>' width="300"> 
      </a>
    </div>
    <div class="m-t-10 p-20">
      <form class="m-t-20" method="post">
      <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

        <div class="form-group row">
          <div class="col-xs-12">
            <input class="form-control" type="text" required="required" placeholder="Username" name="username">
          </div>
        </div>
        <div class="form-group row">
          <div class="col-xs-12">
            <input class="form-control" type="password" placeholder="Password" name="password">
          </div>
        </div>
        <div class="form-group row">
          <div class="col-xs-12">
            <div class="checkbox checkbox-custom">
              <input id="checkbox-signup" type="checkbox"> <label for="checkbox-signup"> Nhớ mật khẩu </label>
            </div>
          </div>
        </div>
        <div class="form-group text-center row m-t-10">
          <div class="col-xs-12">
            <button class="btn btn-success btn-block waves-effect waves-light" type="submit">Đăng nhập</button>
          </div>
        </div>
        <div class="form-group row m-t-30 m-b-0">
          <div class="col-sm-12">
            <a href="pages-recoverpw.html" class="text-muted"><i class="fa fa-lock m-r-5"></i> Quên mật khẩu?</a>
          </div>
        </div>
      </form>
    </div>

    <div class="clearfix"></div>
  </div>
</div>
<!-- end card-box-->

<div class="m-t-20">
  <div class="text-xs-center">
    <p class="text-white">
      Chưa có tài khoản? <a href="${pageContext.request.contextPath}/pages/register.html" class="text-white m-l-5"><b>Đăng ký</b></a>
    </p>
  </div>
</div>