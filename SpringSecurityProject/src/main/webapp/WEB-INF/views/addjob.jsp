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
					<h1>Post Job</h1>
					<form:form role="form" modelAttribute="newjob" action="postjob"
						method="post">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Company
								Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<form:input type="text" class="form-control" path="companyName"
										placeholder="Enter your Company Name" />
									<form:errors path="companyName" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Required
								Experience</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<form:input type="text" class="form-control" path="experience"
										placeholder="Enter Required Experience" />
									<form:errors path="experience" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Job
								Description</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<form:input type="text" class="form-control"
										path="jobDescription" placeholder="Enter Job Description" />
									<form:errors path="jobDescription" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Job
								Title</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<form:input type="text" class="form-control" path="jobTitle"
										placeholder="Enter Job Title" />
									<form:errors path="jobTitle" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Job
								Location</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<form:input type="text" class="form-control" path="location"
										placeholder="Location of Job" />
									<form:errors path="location" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>


						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Skill
								Required</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<form:input type="text" class="form-control"
										path="skillsRequired" placeholder="Skills Required" />
									<form:errors path="skillsRequired" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>


						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">No.of
								Vacancies:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<form:input type="text" class="form-control" path="vacancies"
										placeholder="No of vacancies" />
									<form:errors path="vacancies" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Salary:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<form:input type="text" class="form-control" path="salary"
										placeholder="Salary" />
									<form:errors path="salary" cssStyle="color:Red"></form:errors>
								</div>
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
