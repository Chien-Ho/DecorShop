	$(document).ready(function(){
	$('#formSubmit').submit(function(e){
		e.preventDefault();
		var data = {};
		var formData = ('#formSubmit').serializeArray();
		$.each(formData, function(i,v) {
			data[""+v.name+""] = v.value;
		});
		var id = $('#categoryId').val();
		if(id== ""){
			addCategory(data);
		}else{
			updateCategory(data);
		}
		
	});
	});
	function addCategory(data) {
		$.ajax({
			url : 'http://localhost:8182/category',
			type: 'post',
			data: JSON.stringify(data),
			contentType: 'application/json',
			dataType: 'json',
			success: function() {
				window.location.href = "@{/category-list}";
			}
			error: function() {
				window.location.href = "@{/category-list}";
			}
		});
	};
	function updateCategory(data) {
		$.ajax({
			url : 'http://localhost:8182/category',
			type: 'put',
			data: JSON.stringify(data),
			contentType: 'application/json',
			dataType: 'json',
			success: function() {
				window.location.href = "@{/category-list}";
			}
			error: function() {
				window.location.href = "@{/category-list}";
			}
		});
	};
