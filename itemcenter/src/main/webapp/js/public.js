(function(w,d,u){
	var form = util.get('form');
	if(!form){
		return;
	}
	var title = form['title'];
	var summary = form['summary'];
	var image = form['imageURL'];
	var detail = form['detail'];
	var price = form['price'];
	var isSubmiting = false;
	var imgpre = util.get('imgpre');
	var loading = new Loading();
	var page = {
		init:function(){
			form.addEventListener('submit',function(e){
				if(!isSubmiting && this.check()){
					price.value = Number(price.value);
					isSubmiting = true;
					form.submit();
				}
			}.bind(this),false);
			[title,summary,image,detail,price].forEach(function(item){
				item.addEventListener('input',function(e){
					item.classList.remove('z-err');
				}.bind(this),false);
			}.bind(this));
			image.addEventListener('input',function(e){
				var value = image.value.trim();
				if(value != ''){
					imgpre.src = value;
				}
			}.bind(this),false);
		},
		check:function(){
			var result = true;
			[
				[title,function(value){return value.length<2 || value.length>80}],
				[summary,function(value){return value.length<2 || value.length>140}],
				//^是开头符号 $是结尾符号。／在这里是转意符，不代表任何意思
				//Returns a Boolean value that indicates whether or not a pattern exists in a searched string.test(value)
				[image,function(value){
				if(value == '')
					return false;
				else
				    return value == '' || !(/*/^(http|https):\/\//.test(value) && *//\.(jpg|gif|png)$/.test(value))}],
				[detail,function(value){return value.length<2 || value.length>1000}],
				[price,function(value){return value == '' || !Number(value)}]
			].forEach(function(item){
				//item[0]为前半部分如输入框，1为后面的函数整体
				var value = item[0].value.trim();//此时value为输入框填入的内容。
				//alert(value);
				//alert(item[0]);
                //alert(item[1]);
                //alert(item[1](value));
				if(item[1](value)){
				    //只要有一个item[1](value)返回true（check校验不通过），则result为false
					item[0].classList.add('z-err');
					result = false;
				}
				item[0].value = value;
			});
			return result;
		}
	};
	page.init();
})(window,document);