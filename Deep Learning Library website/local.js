$(document).ready(function(){
 
    $("button.addRow").click(function(){
   	var tabrow ="<tr>"
   				 	+"<th><button class =\"delRow\">delete</button></th>"
   				 	+"<td></td>"
   				 	+"<td></td>"
   				 	+"<td></td>"
   				 	+"<td></td>"
   				+"</tr>";
   	$("#contactTableBody").append(tabrow);
   	console.log("added Row");
   });

   $("button.delRow").click(function(){
   	alert("row deleted");
   	var txt = $(this).parent().parent().remove();
   	console.log("deleted row");
   });
  
   $("#contactTableBody").on('click','td',function(){

			if($(this).has('input').length==0)
			{
				var oldVal  = $('#contactTable').find('input').val();
				$('#contactTable').find('input').parent().remove('input').html(oldVal);
				value = $(this).text();
				$(this).html('<input type="text" value="'+value+'" autofocus>');
				console.log("value Changed ");
			}
	});
 	
 	/*From w3schools*/
   	var holdAltKey = false;
	$(document).keydown(function(event){
			console.log("hold altKey "+event.altKey);
			holdAltKey = event.altKey;

	 });
	$(document).keyup(function(event){
			console.log("hold altKey "+event.altKey);
			holdAltKey = false;
	});
	$('#contactTableBody').on('mouseout','td',function(){
			$(".changeBlueRed").removeClass("changeBlueRed");
	});
	$('#contactTableBody').on('mouseover','td',function(){
			if(holdAltKey)
			{
				console.log("mouse over altKey "+event.altKey);
				$(".changeBlueRed").removeClass("changeBlueRed");
				$(this).addClass("changeBlueRed");
				
			}
	});
	$(this).dblclick(function(){
        $(this).fadeIn("1000");
        
    });

    $("#image1").dblclick(function()
	{
	var img1=$("img#image1");
	img1.animate({height:'300px',opacity:'0.4'},"slow"); 
	img1.animate({width:'300px',opacity:'0.8'},"slow");
	img1.animate({height:'100px',opacity:'0.4'},"slow"); 
	img1.animate({width:'100px',opacity:'0.8'},"slow");
	img1.animate({left:'100px',height:'300px',width:'300px'},"slow",function(){alert("Done!")}); 
	
	});
	$("#image1").mouseleave(function(){
	("img#image1").stop();
	alert("Done!");
	})

	$("#fadein").click(function(){
        $("#image2").fadeIn("slow");
        
    });
    $("#fadeout").click(function(){
        $("#image2").fadeOut("slow");
        
    });
    $("#fadeto").click(function(){
        $("#image2").fadeTo("slow",0.5);
        
    });
    $("#fadetoggle").click(function(){
        $("#image2").fadeToggle(3000);   
    });
    $("#image3").click(function(){
        $("#image4").show();
        $("#image3").hide();
    });
    $("#image4").click(function(){
        $("#image3").show();
        $("#image4").hide();
    });
});
