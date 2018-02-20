/**
 * 
 */
function toLocalDateFormat(time){	
	if(time){
	     var date=new Date(time);
	
	      return date.getFullYear()
			+ "-"
			+ ((date.getMonth() + 1) <= 9 ? ("0" + (date.getMonth() + 1))
					: (date.getMonth() + 1)) + "-"
			+ (date.getDate() <= 9 ? ("0" + date.getDate()) : date.getDate())+" "
			+(date.getHours()<=9?("0"+date.getHours()):date.getHours())+":"
			+(date.getMinutes()<=9?("0"+date.getMinutes()):date.getMinutes())+":"
			+(date.getSeconds()<=9?("0"+date.getSeconds()):date.getSeconds());
       }else{
	   return "";
   }
}


function toLocalDateFormats(time){	
	if(time){
	     var date=new Date(time);
	
	      return date.getFullYear()
			+ "-"
			+ ((date.getMonth() + 1) <= 9 ? ("0" + (date.getMonth() + 1))
					: (date.getMonth() + 1)) + "-"
			+ (date.getDate() <= 9 ? ("0" + date.getDate()) : date.getDate())+" "
			+(date.getHours()<=9?("0"+date.getHours()):date.getHours())+":"
			+(date.getMinutes()<=9?("0"+date.getMinutes()):date.getMinutes());
       }else{
	   return "";
   }
}
