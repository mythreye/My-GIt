<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.login-container {
	margin-top: 5%;
	margin-bottom: 5%;
}

.login-form-1 {
	padding: 5%;
	box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0
		rgba(0, 0, 0, 0.19);
}

.login-form-1 h3 {
	text-align: center;
	color: #333;
}

.login-form-2 {
	padding: 5%;
	background: #0062cc;
	box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0
		rgba(0, 0, 0, 0.19);
}

.login-form-2 h3 {
	text-align: center;
	color: #fff;
}

.login-container form {
	padding: 10%;
}

.btnSubmit {
	width: 50%;
	border-radius: 1rem;
	padding: 1.5%;
	border: none;
	cursor: pointer;
}

.login-form-1 .btnSubmit {
	font-weight: 600;
	color: #fff;
	background-color: #0062cc;
}

.login-form-2 .btnSubmit {
	font-weight: 600;
	color: #0062cc;
	background-color: #fff;
}

.login-form-2 .ForgetPwd {
	color: #fff;
	font-weight: 600;
	text-decoration: none;
}

.login-form-1 .ForgetPwd {
	color: #0062cc;
	font-weight: 600;
	text-decoration: none;
}

.glass {
	/* background styles */
	position: relative;
	display: inline-block;
	padding: 5px 15px;
	background-color: #ff7b25; /*for compatibility with older browsers*/
	/* text styles */
	text-decoration: none;
	color: #ffffff;
	font-size: 25px;
	font-family: sans-serif;
	font-weight: 100;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	border: 1px solid #192B42;
}
</style>
<div class="container login-container">
	<div class="row">

		<c:if test="${haserror}">
			<div class="alert alert-danger">
				<strong>${error}</strong>
			</div>
		</c:if>
		<c:if test="${showmess}">
			<div class="alert alert-success">
				<strong>${message}</strong>
			</div>
		</c:if>

		<div class="main">
			<div class="main-center">

				<div class="col-md-12 login-form-1" style="min-height: 722px;">
					<h1>Sign up once</h1>
					<form:form role="form" modelAttribute="myCustomer"
						action="addcustomer" method="post">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Your
								Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="text" class="form-control"
										path="customername" placeholder="Enter your Name" />
									<form:errors path="customername" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your
								Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<form:input type="text" class="form-control"
										path="customeremail" placeholder="Enter your Email" />
									<form:errors path="customeremail" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your
								Phone</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-mobile fa" aria-hidden="true"></i></span>
									<form:input type="text" class="form-control"
										path="customerphone" placeholder="Enter your phone no" />
									<form:errors path="customerphone" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="password">Password</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
								<form:input type="password" class="form-control"
									name="customerpassword" path="customerpassword"
									placeholder="Enter your Password" />
								<form:errors path="customerpassword" cssStyle="color:Red"></form:errors>
							</div>
						</div>
						<div class="form-group">
							<label for="password">Role</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span>
								<form:select class="form-control" name="customerpassword"
									path="customerrole">
									<form:option value="ROLE_USER">Employee</form:option>
									<form:option value="ROLE_ADMIN">Employer</form:option>
								</form:select>
								<form:errors path="customerrole" cssStyle="color:Red"></form:errors>
							</div>
						</div>

						<div class="form-group ">
							<input type="submit" id="button"
								class="btn btn-success btn-lg btn-block login-button">

						</div>

					</form:form>

				</div>
			</div>
		</div>
	</div>
</div>
