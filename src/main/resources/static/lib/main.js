/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	var __webpack_modules__ = ({

/***/ "./src/_javascript/components/notificacao/index.js":
/*!*********************************************************!*\
  !*** ./src/_javascript/components/notificacao/index.js ***!
  \*********************************************************/
/*! namespace exports */
/*! export default [provided] [no usage info] [missing usage info prevents renaming] */
/*! other exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_exports__, __webpack_require__.r, __webpack_require__.d, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "default": () => __WEBPACK_DEFAULT_EXPORT__
/* harmony export */ });
var notificacao = {
  bind: function bind() {
    var $notification = document.querySelector("[data-notification]");
    var $notificationDelete = document.querySelectorAll(".notification .delete");

    if ($notification) {
      var $notificationbody = document.querySelector(".column .notification").parentNode;
      setTimeout(function () {
        $notificationbody.parentNode.removeChild(notificationbody);
      }, 5000);
    }

    if ($notificationDelete) {
      (document.querySelectorAll(".notification .delete") || []).forEach(function ($delete) {
        var $notification = $delete.parentNode;
        $delete.addEventListener("click", function () {
          $notification.parentNode.removeChild($notification);
        });
      });
    }
  }
};
/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (notificacao);

/***/ }),

/***/ "./src/_javascript/pages/cadastro-participante/index.js":
/*!**************************************************************!*\
  !*** ./src/_javascript/pages/cadastro-participante/index.js ***!
  \**************************************************************/
/*! namespace exports */
/*! export default [provided] [no usage info] [missing usage info prevents renaming] */
/*! other exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_require__.r, __webpack_exports__, __webpack_require__.d, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "default": () => /* binding */ AddParticipante
/* harmony export */ });
function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

var AddParticipante = /*#__PURE__*/function () {
  function AddParticipante() {
    var _this = this;

    _classCallCheck(this, AddParticipante);

    this.currentTab = 0;
    this.showTab(this.currentTab);
    this.bind();
    document.querySelector(".button-cadastro-continuar").addEventListener("click", function () {
      return _this.nextPrev(1);
    });
    document.querySelector(".button-cadastro-voltar").addEventListener("click", function () {
      return _this.nextPrev(-1);
    });
    document.querySelector(".modal-cadastrar-paciente").addEventListener("click", function () {
      document.querySelector(".modal-paciente").style.display = "block";
    });
    document.querySelector(".modal-cadastrar-cuidador").addEventListener("click", function () {
      document.querySelector(".modal-cuidador").style.display = "block";
    });
    document.querySelectorAll(".delete,.close-modal,.modal-background").forEach(function (button) {
      return button.addEventListener("click", function () {
        document.querySelector(".modal-cuidador").style.display = "none";
        document.querySelector(".modal-paciente").style.display = "none";
      });
    });
  }

  _createClass(AddParticipante, [{
    key: "showTab",
    value: function showTab(currentTab) {
      var tabs = document.getElementsByClassName("tab");
      tabs[currentTab].style.display = "block";

      if (currentTab === 0) {
        document.querySelector(".button-cadastro-voltar").style.visibility = "hidden";
      } else {
        document.querySelector(".button-cadastro-voltar").style.visibility = "visible";
      }

      if (currentTab === tabs.length - 1) {
        document.querySelector(".button-cadastro-continuar").innerHTML = "Finalizar &#10003;";
      } else {
        document.querySelector(".button-cadastro-continuar").innerHTML = "Continuar";
      }

      this.fixStepIndicator(currentTab);
    }
  }, {
    key: "fixStepIndicator",
    value: function fixStepIndicator(currentTab) {
      var i;
      var sessions = document.getElementsByClassName("session-item");

      for (i = 0; i < sessions.length; i++) {
        if (i > currentTab) {
          sessions[i].classList.remove("item-checked");
        } else if (i < currentTab) {
          sessions[i].classList.add("item-checked");
        }
      }

      sessions[currentTab].classList.add("item-checked");
    }
  }, {
    key: "nextPrev",
    value: function nextPrev(nextPrevtab) {
      var tabs = document.getElementsByClassName("tab");
      tabs[this.currentTab].style.display = "none";
      this.currentTab = this.currentTab + nextPrevtab;

      if (this.currentTab >= tabs.length) {
        document.getElementById("regForm").submit();
        return false;
      }

      this.showTab(this.currentTab);
    }
  }, {
    key: "bind",
    value: function bind() {
      $(document).ready(function () {
        $("#paciente").select2({
          ajax: {
            url: "/api/pacientes/select/",
            dataType: "json",
            delay: 250,
            processResults: function processResults(response) {
              return {
                results: response
              };
            },
            cache: true,
            data: function data(params) {
              var queries = {
                query: params.term
              };
              return queries;
            }
          }
        });
      });
      $(document).ready(function () {
        $("#cuidador").select2({
          ajax: {
            url: "/api/cuidadores/select/",
            dataType: "json",
            delay: 250,
            processResults: function processResults(response) {
              return {
                results: response
              };
            },
            cache: true,
            data: function data(params) {
              var queries = {
                query: params.term
              };
              return queries;
            }
          }
        });
      });
      document.querySelector("#cadastrar-cuidador").addEventListener("click", function () {
        var cuidadorData = {
          nome: document.querySelector("#nome-cuidador").value,
          cpf: document.querySelector("#cpf-cuidador").value,
          dataNascimento: document.querySelector("#nascimento-cuidador").value,
          email: document.querySelector("#email-cuidador").value,
          genero: document.querySelector("#genero-cuidador").value,
          estadoCivil: document.querySelector("#estadocivil-cuidador").value,
          telefone: [document.querySelector("#telefone-cuidador").value],
          endereco: {
            numero: document.querySelector("#numero-cuidador").value,
            complemento: document.querySelector("#complemento-cuidador").value,
            cep: document.querySelector("#cep-cuidador").value,
            rua: {
              nome: document.querySelector("#rua-cuidador").value,
              bairro: {
                nome: document.querySelector("#bairro-cuidador").value,
                cidade: {
                  nome: document.querySelector("#cidade-cuidador").value,
                  estado: {
                    nome: document.querySelector("#estado-cuidador").value
                  }
                }
              }
            }
          }
        };
        $.ajax({
          type: "POST",
          url: "/api/cuidadores/",
          data: JSON.stringify(cuidadorData),
          contentType: "application/json",
          success: function success(res) {
            var newState = new Option(res.nome, res.id, true, true);
            $("#cuidador").append(newState).trigger("change");
            document.querySelector(".modal-cuidador").style.display = "none";
          },
          error: function error(XMLHttpRequest, textStatus, errorThrown) {
            mostrarErrosCuidador(XMLHttpRequest.responseJSON);
          }
        });
      });
      document.querySelector("#cadastrar-paciente").addEventListener("click", function () {
        var pacienteData = {
          nome: document.querySelector("#nome-paciente").value,
          cpf: document.querySelector("#cpf-paciente").value,
          dataNascimento: document.querySelector("#nascimento-paciente").value,
          email: document.querySelector("#email-paciente").value,
          genero: document.querySelector("#genero-paciente").value,
          estadoCivil: document.querySelector("#estadocivil-paciente").value,
          parkinson: document.querySelector("#parkinson").value == "on" ? true : false,
          alzheimer: document.querySelector("#alzheimer").value == "on" ? true : false,
          telefone: [document.querySelector("#telefone-paciente").value],
          endereco: {
            numero: document.querySelector("#numero-paciente").value,
            complemento: document.querySelector("#complemento-paciente").value,
            cep: document.querySelector("#cep-paciente").value,
            rua: {
              nome: document.querySelector("#rua-paciente").value,
              bairro: {
                nome: document.querySelector("#bairro-paciente").value,
                cidade: {
                  nome: document.querySelector("#cidade-paciente").value,
                  estado: {
                    nome: document.querySelector("#estado-paciente").value
                  }
                }
              }
            }
          }
        };
        $.ajax({
          type: "POST",
          url: "/api/pacientes/",
          data: JSON.stringify(pacienteData),
          contentType: "application/json",
          success: function success(res) {
            console.log(res);
            var newState = new Option(res.nome, res.id, true, true);
            $("#paciente").append(newState).trigger("change");
            console.log(res);
            document.querySelector(".modal-paciente").style.display = "none";
          },
          error: function error(XMLHttpRequest, textStatus, errorThrown) {
            mostrarErrosPaciente(XMLHttpRequest.responseJSON);
          }
        });
      });

      function mostrarErrosPaciente(data) {
        var camposErros = data.campos;
        var notificationErrorsPaciente = document.querySelector("#noticacao-erros-paciente");
        notificationErrorsPaciente.innerHTML = "";
        camposErros.map(function (campo) {
          var line = "<div class=\"notification is-light is-danger\">\n              <p>".concat(campo.mensagem, "</p>\n          </div>");
          notificationErrorsPaciente.innerHTML += line;
        });
      }

      function mostrarErrosCuidador(data) {
        var camposErros = data.campos;
        var notificationErrorsCuidador = document.querySelector("#noticacao-erros-cuidador");
        notificationErrorsCuidador.innerHTML = "";
        camposErros.map(function (campo) {
          var line = "<div class=\"notification is-light is-danger\">\n              <p>".concat(campo.mensagem, "</p>\n          </div>");
          notificationErrorsCuidador.innerHTML += line;
        });
      }
    }
  }]);

  return AddParticipante;
}();



/***/ }),

/***/ "./src/_javascript/pages/detalhes/index.js":
/*!*************************************************!*\
  !*** ./src/_javascript/pages/detalhes/index.js ***!
  \*************************************************/
/*! namespace exports */
/*! export default [provided] [no usage info] [missing usage info prevents renaming] */
/*! other exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_exports__, __webpack_require__.r, __webpack_require__.d, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "default": () => __WEBPACK_DEFAULT_EXPORT__
/* harmony export */ });
var Detalhes = {
  opcoes: function opcoes() {
    var botaoOpcao = document.querySelector(".detalhes-opcoes-botao");

    if (botaoOpcao) {
      botaoOpcao.addEventListener("click", function () {
        var bodyOptions = document.querySelector(".detalhes-opcoes-body");
        bodyOptions.style.display == "block" ? bodyOptions.style.display = "none" : bodyOptions.style.display = "block";
      });
    }
  }
};
/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (Detalhes);

/***/ }),

/***/ "./src/_javascript/utils/mascara.js":
/*!******************************************!*\
  !*** ./src/_javascript/utils/mascara.js ***!
  \******************************************/
/*! namespace exports */
/*! export default [provided] [no usage info] [missing usage info prevents renaming] */
/*! other exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_exports__, __webpack_require__.r, __webpack_require__.d, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "default": () => __WEBPACK_DEFAULT_EXPORT__
/* harmony export */ });
var mascara = function mascara() {
  var masks = {
    data: function data(value) {
      return value.replace(/\D/g, "").replace(/(\d{2})(\d)/, "$1/$2").replace(/(\d{2})(\d)/, "$1/$2").replace(/(\/\d{4})\d+?$/, "$1");
    },
    cpf: function cpf(value) {
      return value.replace(/\D/g, "").replace(/(\d{3})(\d)/, "$1.$2").replace(/(\d{3})(\d)/, "$1.$2").replace(/(\d{3})(\d{1,2})/, "$1-$2").replace(/(-\d{2})\d+?$/, "$1");
    }
  };
  document.querySelectorAll("input").forEach(function ($input) {
    var campo = $input.dataset.mask;

    if (campo) {
      $input.addEventListener("input", function (event) {
        event.target.value = masks[campo](event.target.value);
      }, false);
    } else {
      return;
    }
  });
};

/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (mascara);

/***/ }),

/***/ "./src/index.js":
/*!**********************!*\
  !*** ./src/index.js ***!
  \**********************/
/*! namespace exports */
/*! exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_require__, __webpack_require__.r, __webpack_exports__, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _javascript_components_notificacao__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./_javascript/components/notificacao */ "./src/_javascript/components/notificacao/index.js");
/* harmony import */ var _javascript_pages_detalhes__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./_javascript/pages/detalhes */ "./src/_javascript/pages/detalhes/index.js");
/* harmony import */ var _javascript_pages_cadastro_participante__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./_javascript/pages/cadastro-participante */ "./src/_javascript/pages/cadastro-participante/index.js");
/* harmony import */ var _javascript_utils_mascara__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./_javascript/utils/mascara */ "./src/_javascript/utils/mascara.js");
__webpack_require__(/*! ./_sass/main.scss */ "./src/_sass/main.scss");


 // import api from "./service/api";



document.addEventListener("DOMContentLoaded", function () {
  _javascript_components_notificacao__WEBPACK_IMPORTED_MODULE_0__.default.bind();
  _javascript_pages_detalhes__WEBPACK_IMPORTED_MODULE_1__.default.opcoes();
  (0,_javascript_utils_mascara__WEBPACK_IMPORTED_MODULE_2__.default)();

  if (document.querySelector(".button-cadastro-continuar")) {
    new _javascript_pages_cadastro_participante__WEBPACK_IMPORTED_MODULE_3__.default();
  } // api.getListaFiltrada("chamadas", "xx", 0).then((res) => console.log(res));

});

/***/ }),

/***/ "./src/_sass/main.scss":
/*!*****************************!*\
  !*** ./src/_sass/main.scss ***!
  \*****************************/
/*! namespace exports */
/*! exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_require__.r, __webpack_exports__, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
// extracted by mini-css-extract-plugin


/***/ })

/******/ 	});
/************************************************************************/
/******/ 	// The module cache
/******/ 	var __webpack_module_cache__ = {};
/******/ 	
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/ 		// Check if module is in cache
/******/ 		if(__webpack_module_cache__[moduleId]) {
/******/ 			return __webpack_module_cache__[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = __webpack_module_cache__[moduleId] = {
/******/ 			// no module.id needed
/******/ 			// no module.loaded needed
/******/ 			exports: {}
/******/ 		};
/******/ 	
/******/ 		// Execute the module function
/******/ 		__webpack_modules__[moduleId](module, module.exports, __webpack_require__);
/******/ 	
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/ 	
/************************************************************************/
/******/ 	/* webpack/runtime/define property getters */
/******/ 	(() => {
/******/ 		// define getter functions for harmony exports
/******/ 		__webpack_require__.d = (exports, definition) => {
/******/ 			for(var key in definition) {
/******/ 				if(__webpack_require__.o(definition, key) && !__webpack_require__.o(exports, key)) {
/******/ 					Object.defineProperty(exports, key, { enumerable: true, get: definition[key] });
/******/ 				}
/******/ 			}
/******/ 		};
/******/ 	})();
/******/ 	
/******/ 	/* webpack/runtime/hasOwnProperty shorthand */
/******/ 	(() => {
/******/ 		__webpack_require__.o = (obj, prop) => Object.prototype.hasOwnProperty.call(obj, prop)
/******/ 	})();
/******/ 	
/******/ 	/* webpack/runtime/make namespace object */
/******/ 	(() => {
/******/ 		// define __esModule on exports
/******/ 		__webpack_require__.r = (exports) => {
/******/ 			if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 				Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 			}
/******/ 			Object.defineProperty(exports, '__esModule', { value: true });
/******/ 		};
/******/ 	})();
/******/ 	
/************************************************************************/
/******/ 	// startup
/******/ 	// Load entry module
/******/ 	__webpack_require__("./src/index.js");
/******/ 	// This entry module used 'exports' so it can't be inlined
/******/ })()
;
//# sourceMappingURL=main.js.map