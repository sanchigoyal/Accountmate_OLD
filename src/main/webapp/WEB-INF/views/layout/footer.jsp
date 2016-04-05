<div class="container">
	<div class="row">
		<div class="col-md-12">
			<hr/>
		</div>
		<div class="col-md-6">
			<p>Copyright &copy; Accountmate Inc.
			<a data-toggle="modal" href="#footer">Terms and Conditions</a></p>
			
			<!----Modal--->
			<div class="modal fade" id="footer" tabinex="-1" role="dialog" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h2>Terms and Conditions</h2>
						</div>
						<div class="modal-body">
							<p>All copyright, trade marks, design rights, patents and other intellectual property rights (registered and unregistered) 
							in and on Accountmate belong to the Accountmate Inc. and/or third parties (which may include you or other users). 
							The Accountmate Inc. reserves all of its rights in Accountmate. Nothing in the Terms grants you a right or licence
							to use any trade mark, design right or copyright owned or controlled by the Accountmate Inc. or any other third party 
							except as expressly provided in the Terms.</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-2 col-md-offset-4">
			<ul class="list-inline pull-right">
			  <li><a href="/Accountmate/contact" class="text-right">Contact</a></li>
			  <li><a href="/Accountmate/aboutUs" class="text-right">About</a></li>
			</ul>
			
			
		</div>
	</div>
</div>	
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/formValidation.min.js"></script>
<script src="resources/js/bootstrap.mod.min.js"></script>
<script src="resources/js/bootstrap-formhelper-min.js"></script>
<script src="resources/js/moment.js"></script>
<script src="resources/js/daterangepicker.js"></script>

<script>
$(document).ready(function() {         
	     var cb = function(start, end, label) {
	    	 // On date change this block is called
	         $('#businessDate span').html(start.format('MMMM D, YYYY'));
	         $('#businessDate input').val(start.format('YYYY-MM-DD'));
	       };
	     var optionSet = {
	   	         showDropdowns: true,
	   	         showWeekNumbers: false,
	   	         timePicker: false,
	   	         timePickerIncrement: 1,
	   	         timePicker12Hour: true,
	   	         ranges: {
	   	            'Today': [moment(), moment()],
	   	            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')]
	   	         },
	   	         opens: 'left',
	   	         buttonClasses: ['btn btn-default'],
	   	         applyClass: 'btn-small btn-primary',
	   	         cancelClass: 'btn-small',
	   	         singleDatePicker: true,
	   	         format: 'MM/DD/YYYY',
	   	         separator: ' to ',
	   	         locale: {
	   	             applyLabel: 'Search',
	   	             cancelLabel: 'Clear',
	   	             fromLabel: 'From',
	   	             toLabel: 'To',
	   	             customRangeLabel: 'Custom',
	   	             daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr','Sa'],
	   	             monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
	   	             firstDay: 1
	   	         }
	   	       };
	     
	      $('#businessDate span').html(moment().format('MMMM D, YYYY'));
	      $('#businessDate input').val(moment().format('YYYY-MM-DD'));
	      $('#businessDate').daterangepicker(optionSet, cb);
	     
	});
	</script>
