'use strict';

document.addEventListener('DOMContentLoaded', function () {
  console.log('Hello Bulma!');

  var notification = document.querySelector('[data-notification]');

  if (notification) {
    var notificationbody = document.querySelector('.column .notification').parentNode;
    console.log(notificationbody);

    setTimeout(function () {
      notificationbody.parentNode.removeChild(notificationbody);
    }, 5000);
  }
});

document.addEventListener('DOMContentLoaded', function () {
  (document.querySelectorAll('.notification .delete') || []).forEach(function ($delete) {
    var $notification = $delete.parentNode;

    $delete.addEventListener('click', function () {
      $notification.parentNode.removeChild($notification);
    });
  });
});

document.querySelector('.detalhes-opcoes-botao').addEventListener('click', function () {
  var bodyOptions = document.querySelector('.detalhes-opcoes-body');
  bodyOptions.style.display == 'block' ? bodyOptions.style.display = 'none' : bodyOptions.style.display = 'block';
});

var currentTab = 0;
showTab(currentTab);

document.querySelector(".form-navigation-next").addEventListener("click", function () {
  return nextPrev(1);
});

document.querySelector(".form-navigation-back").addEventListener("click", function () {
  return nextPrev(-1);
});

function showTab(tabWillBeDisplayed) {
  var tabs = document.getElementsByClassName("tab");
  tabs[tabWillBeDisplayed].style.display = "block";

  if (tabWillBeDisplayed == 0) {
    document.querySelector(".form-navigation-back").style.visibility = "hidden";
  } else {
    document.querySelector(".form-navigation-back").style.visibility = "visible";
  }

  if (tabWillBeDisplayed == tabs.length - 1) {
    document.querySelector(".form-navigation-next").innerHTML = "Finalizar";
  } else {
    document.querySelector(".form-navigation-next").innerHTML = "Próximo";
  }

  fixStepIndicator(tabWillBeDisplayed);
}

function nextPrev(tabWillBeDisplayed) {
  var tabs = document.getElementsByClassName("tab");
  tabs[currentTab].style.display = "none";
  currentTab = currentTab + tabWillBeDisplayed;

  if (currentTab >= tabs.length) {
    document.getElementById("regForm").submit();
    return false;
  }

  window.scrollTo({
    top: 0,
    left: 0,
    behavior: 'smooth'
  });
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var x,
      y,
      i,
      valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false:
      valid = false;
    }
  }
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(tabWillBeDisplayed) {
  var tabs = document.getElementsByClassName("step-info-section");

  for (var i = 0; i < tabs.length; i++) {
    if (i > tabWillBeDisplayed) {
      tabs[i].classList.remove("step-info-checked");
    } else if (i < tabWillBeDisplayed) {
      tabs[i].classList.add("step-info-checked");
    }
  }

  tabs[tabWillBeDisplayed].classList.add("step-info-checked");
}