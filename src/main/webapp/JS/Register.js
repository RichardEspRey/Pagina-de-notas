
$(function(){ 
    var minus = new RegExp("^(?=,*[a-z])");
    var mayus = new RegExp("^(?=.*[A-Z])");
    var len = new RegExp("^(?=.{8,})");
    var punto = new RegExp("^(?=.*[.])");
    var num = new RegExp("^(?=.*[0-9])");
  
    var regExp=[mayus,minus,len,punto, num];
    var elementos =[$("#mayus"),$("#minus"),$("#len"),$("#punto"),$("#num")];

   $("#contra").on("keyup", function(){
       var pass = $("#contra").val();
       
       for (var i=0; i<5; i++){
           if(regExp[i].test(pass)){
             elementos[i].hide();  
           }else{
                elementos[i].show(); 
           }
       }
     
       
      
   });
   
$("#registroForm").submit(function(event){
             event.preventDefault();
             alert("Registro con exito");
         });
 

   


 
  
 });
 

         
 
 