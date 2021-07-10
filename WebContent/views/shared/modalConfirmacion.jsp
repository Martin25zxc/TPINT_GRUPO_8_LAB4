<%
String modalText =request.getParameter("confirmationModalText");
%>	
<!-- Modal -->
<div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog"
	aria-labelledby="confirmationModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
	
			<div class="modal-header">
				<h5 class="modal-title" id="confirmationModalLabel">Confirmación</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body"><%=modalText%></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<button type="submit" class="btn btn-primary">Confirmar</button>
			</div>
		</div>
	</div>
</div>
