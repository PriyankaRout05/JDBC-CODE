GET: $(document).ready(
	function(){
		
		//GET REQUEST
		$("accessportal").click(function(event){
			event.preventDefault();
			ajaxGet();	
			
		});
		
		//Do GET
		function ajaxGet(){
			$.ajax({
				url : "http://localhost:8080/access",
				success : function(result){
					$("#apiResponse").html(result);
				}
			});
		}
		})
	
