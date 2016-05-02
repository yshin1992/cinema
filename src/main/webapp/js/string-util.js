//去除空格
String.prototype.trim = function(){
	return this.replace(/(^\s*)|(\s*$)/g,"");
}