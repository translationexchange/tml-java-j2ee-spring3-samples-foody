<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tml" uri="/tml-tags"%>

<div class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only"><tml:tr label="Toggle navigation" /></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/"><strong>Foody</strong></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<tml:language_selector type="bootstrap" element="li" />
			</ul>
		</div>
	</div>
</div>