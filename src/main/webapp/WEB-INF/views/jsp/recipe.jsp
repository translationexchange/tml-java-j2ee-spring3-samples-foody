<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tml" uri="/tml-tags"%>

<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" <tml:language_attributes/>>

<head>
<%@ include file="layout/head.jsp"%>
</head>

<body data-spy='scroll' data-target='#nav-categories'>
	<%@ include file="layout/navigation.jsp"%>


	<div class="content">
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="row">
						<div class="col-lg-6 col-sm-7">
							<a href="/" class="back-btn"><tml:tr>Back</tml:tr></a>
							<div class="recipe">
								<h2>
									<tml:tr label="${recipe.name}" />
								</h2>
								<h5>
									<tml:tr label="Preparation" />
								</h5>
								<p>
									<tml:tr label="${recipe.preparation}" />
								</p>
								<hr>
								<h5>
									<tml:tr label="Directions" />
								</h5>
								<ol>
									<c:forEach items="${recipe.directions}" var="direction">
										<li>
											<p>
												<tml:tr label="${direction}" />
											</p>
										</li>
									</c:forEach>
								</ol>
							</div>
						</div>
						<div class="col-sm-5 col-lg-offset-1">
							<div class="panel panel-default">
								<img src="<s:url value="/assets/${recipe.image}"/>"
									class="img-responsive">
								<div class="panel-body">
									<h5>
										<tml:tr label="Ingredient List" />
									</h5>
									<table class="table recipe-table">
										<tbody>
											<c:forEach items="${recipe.ingredients}" var="ingredient">
												<tr>
													<td><tml:tr
															label="${ingredient.quantity} ${ingredient.measurements} ${ingredient.name}" />
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="layout/footer.jsp"%>
</body>
</html>

