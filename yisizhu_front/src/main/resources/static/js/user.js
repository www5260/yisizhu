$("#loginBtn").click(function(){
	var targetUrl = $("#userLoginForm").attr("action");    
	var data = $("#userLoginForm").serialize();     

	$.ajax({
		type: 'post',
		url: 'http://127.0.0.1:8080/sso/ssoLogin/login',
		data: data,
		dataType:'json',
		success:function(n){
			localStorage.setItem("token", n.token);
			var url = n.gotoURL+"?token="+localStorage.getItem("token")+"&da="+new Date().getTime();
			location.href = url;
		},
		error:function(){
			alert("发送请求失败");
		}
	});
});
