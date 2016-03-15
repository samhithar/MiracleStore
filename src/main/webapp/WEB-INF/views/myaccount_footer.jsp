<!-- My Account Footer -->
<div class="footer">
		   <p>Powered By <a href="https://miraclesoft.com/" target="_blank">Miracle Software Systems | SSG</a></p>
		</div>		
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			

			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
		
		<script>

populateCountries("country", "state");	
populateStates("country", "state");	

</script>
	
</body>
</html>