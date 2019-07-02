function getToken(){
	var token = localStorage.token;
	return "token="+token;
}
function createLink(strURL){
	var url = strURL+getToken()+"&date="+new Date();
	location.href = url;
}