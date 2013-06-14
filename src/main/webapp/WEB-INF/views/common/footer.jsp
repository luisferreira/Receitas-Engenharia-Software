		<div id="push"></div>
		</div>
		<div id="footer">
			<div class="container">
				<p class="credit whiteText">Made for Software Engineering class by
					Miguel Ver&iacute;ssimo, Lu&iacute;s Ferreira, Rui Silva e Jo&atilde;o Feteira. LIG 3N1
					2013</p>
			</div>
		</div>
		<script src="/static/js/jquery.js"></script>
		<script src="/static/js/bootstrap.min.js"></script>
		<script src="/static/js/bootstrap-rowlink.min.js"></script>
		<script src="/static/js/bootstrap-confirm.js"></script>
		<script src="/static/js/bootstrap-tagmanager.js"></script>
		<script type="text/javascript">
			<!--
				window.setTimeout(function() {
			    	$("#saveSuccessMessage").fadeTo(500, 0).slideUp(500, function(){
			        	$(this).remove(); 
			    	});
				}, 3500);
			
				$(document).ready(function () {		
		            $("#myInput").on("focus", function() {
		                    $(this).tooltip("show");
		           		}).tooltip({
		                	placement: "bottom",
		                	trigger: "manual"
		            });
		            
		            $("#myInput").on("focusout", function() {
		                    $(this).tooltip("hide");
		            });			
		        	
		            $(".srchBoxType").on("focus", function() {
	                    $(this).tooltip("show");
	           		}).tooltip({
	                	placement: "top",
	                	trigger: "manual"
	            	});
	        
		            $(".srchBoxType").on("focusout", function() {
	                    $(this).tooltip("hide");
	            	});
		            
		            
		            $(".tm-input").tagsManager({
		                typeahead: true,
		                preventSubmitOnEnter: true,
		                isClearInputOnEsc: true,
		                typeahead: true,
		                typeaheadSource: ${existingTags},
		                blinkBGColor_1: '#FFFF9C',
		                blinkBGColor_2: '#CDE69C',
		            });
		            
		            $(".tm-edit").tagsManager({
						prefilled: ${recipe.lastVersion.tagsAsJSArray eq null ? '[]' : recipe.lastVersion.tagsAsJSArray},
		                typeahead: true,
		                preventSubmitOnEnter: true,
		                isClearInputOnEsc: true,
		                typeahead: true,
		                typeaheadSource: ${existingTags},
		                blinkBGColor_1: '#FFFF9C',
		                blinkBGColor_2: '#CDE69C',
		            });
					
		        });
			//-->
		</script>
	</body>
</html>