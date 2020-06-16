const calculateInterest = () => {
$("#calculate").click((event) => {
	event.preventDefault();
	let principal = $("#principal").val();
	let years = Number($("#rate").val());
	let rate = Number($("#years").val());
	const interest = {
		principal,
		years,
		rate
	};
	const url = "interest/simpleInterest";
	
     $.ajax({
    	 type: "POST",
    	 contentType: 'application/json',
    	 url: url,
    	 data: JSON.stringify(interest),
    	 success: (data) => {
    		 console.log("data:",data);
    		 $("#interest").text("Calculated Interest is : "+data);
    	 }
     })
	 
	 
});
}
$(document).ready(() => {
	calculateInterest();
});