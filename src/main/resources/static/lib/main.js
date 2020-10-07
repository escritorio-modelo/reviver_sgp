'use strict';

var masks = {
  cpf: function cpf(value) {
    return value.replace(/\D/g, '').replace(/(\d{3})(\d)/, '$1.$2').replace(/(\d{3})(\d)/, '$1.$2').replace(/(\d{3})(\d{1,2})/, '$1-$2').replace(/(-\d{2})\d+?$/, '$1');
  }
};

document.querySelectorAll('input').forEach(function ($input) {
  var campo = $input.dataset.mask;

  if (campo) {
    $input.addEventListener('input', function (event) {
      event.target.value = masks[campo](event.target.value);
    }, false);
  } else {
    return;
  }
});

document.addEventListener('DOMContentLoaded', () => {
  (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {
    var $notification = $delete.parentNode;

    $delete.addEventListener('click', () => {
      $notification.parentNode.removeChild($notification);
    });
  });
});

var selectElement = document.getElementById('dataInicio');
		selectElement.addEventListener('change', (event) => {
		console.log('entrou')
			const result = document.querySelector('#dataTermino');
			let date = new Date(event.target.value);
			date.setDate(date.getDate() + 2);
			let dd = date.getDate();
			let mm = date.getMonth() + 1; //January is 0!
			let yyyy = date.getFullYear();
			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}

			var dateTerminoMin = yyyy + '-' + mm + '-' + dd;
			result.min = dateTerminoMin;
		});