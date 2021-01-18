<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
    <div class="col-sm-12">
      <div class="btn-group pull-right m-t-15">
        <a type="button" class="btn btn-custom" href="${pageContext.request.contextPath}/pages/project/add.html"> <span class="m-l-5"><i class="fa fa-plus"></i></span> Thêm mới
        </a>
      </div>
      <h4 class="page-title">Danh sách dự án</h4>
    </div>
  </div>
<div class="row">
  <div class="col-sm-12">
    <form:form id="listForm" method="post">
        <div class="row">
          <div class="col-sm-12">
            <div class="card-box table-responsive">
              <table id="datatable-buttons" class="table table-striped table-bordered">
                <thead>
                <tr>
                  <th style="text-align: center; width: 150px;">Thao tác</th>
                  <th style="text-align: center; width: 150px;">Mã dự án</th>
                  <th style="text-align: center; width: 150px;">Tên dự án</th>
                  <th style="text-align: center; width: 150px;">Ngày bắt đầu</th>
                  <th style="text-align: center; width: 150px;">Ngày kết thúc</th>
                  <th style="text-align: center; width: 150px;">Mã phòng ban</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="project" items="${listOfProject }">
                  <tr>
                    <td style="width: 160px; text-align: center !important;">
                      <a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/pages/project/edit.html/${project.id }" title="Edit"><i class="fa fa-pencil"></i></a>
                      <a class="btn btn-danger btn-sm deleteLink" href="${pageContext.request.contextPath}/pages/project/delete.html/${project.id }" title="Delete"><i class="fa fa-trash-o"></i></a>
                    </td>
                    <td style="text-align: center; width: 100px;">${project.id }</td>
                    <td style="text-align: center; width: 100px;">${project.name }</td>
                    <td style="text-align: center; width: 100px;">${project.startDate }</td>
                    <td style="text-align: center; width: 100px;">${project.endDate }</td>
                    <td style="text-align: center; width: 100px;">${project.departmentId }</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
        <input type="hidden" name="crudaction" value="delete" />
      </form:form>
  </div>
</div>
<script>
    $(document).ready(function() {
        var table = $('#datatable-buttons').DataTable({
            dom: 'Bfrtip',
            lengthChange: false,
            buttons: [
              {
                extend: "copy",
                className: "btn-sm"
              },
              {
                extend: "csv",
                charset: 'utf-8',
                bom: true,
                className: "btn-sm"
              },
              {
                extend: "excel",
                className: "btn-sm"
              },
              {
                extend: "pdfHtml5",
                className: "btn-sm"
              },
              {
                extend: "colvis",
                className: "btn-sm"
              }
            ],
            pageLength: 5,
            language: {url: "<c:url value='/themes/plugins/datatables/i18n/Vietnamese.json'/>"},
            initComplete: function () {
              setTimeout( function () {
                table.buttons().container().appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
              }, 10 );
            }
        });
        table.buttons().container().appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
        //Datatables
        
        //deleteLink
        $(".deleteLink").click(function(){
            var id = $(this).attr("id");
            bootbox.confirm("<fmt:message key='confirm.content'/>", function(result) {
                if (result) {
                    $("<input type='hidden' name='pojo.userGroupId' value='"+id+"'>").appendTo($("#listForm"));
                    $("#listForm").submit();
                }
            });
        });
    });
</script>