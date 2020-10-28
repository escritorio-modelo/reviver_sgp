/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	var __webpack_modules__ = ({

/***/ "./src/_javascript/components/DataTablesListFilter/index.js":
/*!******************************************************************!*\
  !*** ./src/_javascript/components/DataTablesListFilter/index.js ***!
  \******************************************************************/
/*! namespace exports */
/*! export default [provided] [no usage info] [missing usage info prevents renaming] */
/*! other exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_exports__, __webpack_require__.r, __webpack_require__.d, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "default": () => __WEBPACK_DEFAULT_EXPORT__
/* harmony export */ });
function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { _defineProperty(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

var DataTablesListFilter = /*#__PURE__*/function () {
  function DataTablesListFilter() {
    _classCallCheck(this, DataTablesListFilter);
  }

  _createClass(DataTablesListFilter, null, [{
    key: "bind",
    value: function bind() {
      var messages = {
        search: "",
        searchPlaceholder: "Procurar paciente",
        info: "Mostrando de _START_ até _END_ de _TOTAL_ registros",
        emptyTable: "Nenhum dado disponível na tabela",
        infoEmpty: "Mostrando de 0 até 0 de 0 registros",
        infoFiltered: "(Filtrado de _MAX_ registros)",
        thousands: ".",
        lengthMenu: "Mostrando _MENU_ registros",
        loadingRecords: "Carregando...",
        paginate: {
          first: "Primeiro",
          last: "Último",
          next: "Próximo",
          previous: "Voltar"
        }
      };
      $("#pacientes").dataTable({
        language: _objectSpread({}, messages),
        dom: ' <"top"f>rt<"bottom"ip><"clear">'
      });
      $("#cuidadores").dataTable({
        language: _objectSpread({}, messages),
        dom: ' <"top"f>rt<"bottom"ip><"clear">'
      });
      $("#chamadas").dataTable({
        language: _objectSpread({}, messages),
        dom: ' <"top"f>rt<"bottom"ip><"clear">'
      });
    }
  }]);

  return DataTablesListFilter;
}();

/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (DataTablesListFilter);

/***/ }),

/***/ "./src/_javascript/components/DetailsOptions/index.js":
/*!************************************************************!*\
  !*** ./src/_javascript/components/DetailsOptions/index.js ***!
  \************************************************************/
/*! namespace exports */
/*! export default [provided] [no usage info] [missing usage info prevents renaming] */
/*! other exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_exports__, __webpack_require__.r, __webpack_require__.d, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "default": () => __WEBPACK_DEFAULT_EXPORT__
/* harmony export */ });
var DetailsOptions = {
  bind: function bind() {
    document.querySelector(".detalhes-opcoes-botao").addEventListener("click", function () {
      var bodyOptions = document.querySelector(".detalhes-opcoes-body");
      bodyOptions.style.display == "block" ? bodyOptions.style.display = "none" : bodyOptions.style.display = "block";
    });
  }
};
/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (DetailsOptions);

/***/ }),

/***/ "./src/_javascript/components/Notificacao/index.js":
/*!*********************************************************!*\
  !*** ./src/_javascript/components/Notificacao/index.js ***!
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
    setTimeout(function () {
      $notification.parentNode.removeChild($notification);
    }, 5000);

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

/***/ "./src/_javascript/controllers/ParticipanteController.js":
/*!***************************************************************!*\
  !*** ./src/_javascript/controllers/ParticipanteController.js ***!
  \***************************************************************/
/*! namespace exports */
/*! export default [provided] [no usage info] [missing usage info prevents renaming] */
/*! other exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_require__, __webpack_exports__, __webpack_require__.r, __webpack_require__.d, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "default": () => __WEBPACK_DEFAULT_EXPORT__
/* harmony export */ });
/* harmony import */ var _domain_Paciente_Paciente__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../domain/Paciente/Paciente */ "./src/_javascript/domain/Paciente/Paciente.js");
/* harmony import */ var _domain_Cuidador_Cuidador__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../domain/Cuidador/Cuidador */ "./src/_javascript/domain/Cuidador/Cuidador.js");
function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }




var ParticipanteController = /*#__PURE__*/function () {
  function ParticipanteController() {
    _classCallCheck(this, ParticipanteController);

    this.currentTab = 0;
    var $ = document.querySelector.bind(document);
    this.buttonNext = $(".button-cadastro-continuar");
    this.buttonPrev = $(".button-cadastro-voltar");
    this.buttonModalAddPaciente = $(".modal-cadastrar-paciente");
    this.buttonModalAddCuidador = $(".modal-cadastrar-cuidador");
    this.closeModal = document.querySelectorAll(".delete,.close-modal,.modal-background");
    this.submitPaciente = $("#cadastrar-paciente");
    this.submitCuidador = $("#cadastrar-cuidador");
  }

  _createClass(ParticipanteController, [{
    key: "bind",
    value: function bind() {
      var _this = this;

      this.buttonNext.addEventListener("click", function () {
        return _this.nextPrev(1);
      });
      this.buttonPrev.addEventListener("click", function () {
        return _this.nextPrev(-1);
      });
      this.buttonModalAddPaciente.addEventListener("click", function () {
        document.querySelector(".modal-paciente").style.display = "block";
      });
      this.buttonModalAddCuidador.addEventListener("click", function () {
        document.querySelector(".modal-cuidador").style.display = "block";
      });
      this.submitPaciente.addEventListener("click", function () {
        return _this.addPaciente();
      });
      this.submitCuidador.addEventListener("click", function () {
        return _this.addCuidador();
      });
      this.closeModal.forEach(function (button) {
        return button.addEventListener("click", function () {
          document.querySelector(".modal-cuidador").style.display = "none";
          document.querySelector(".modal-paciente").style.display = "none";
        });
      });
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
      this.showTab(this.currentTab);
    }
  }, {
    key: "addPaciente",
    value: function addPaciente() {
      var Paciente = new _domain_Paciente_Paciente__WEBPACK_IMPORTED_MODULE_0__.default();
      Paciente.add();
    }
  }, {
    key: "addCuidador",
    value: function addCuidador() {
      var Cuidador = new _domain_Cuidador_Cuidador__WEBPACK_IMPORTED_MODULE_1__.default();
      Cuidador.add();
    }
  }, {
    key: "showTab",
    value: function showTab(currentTab) {
      var tabs = document.getElementsByClassName("tab");
      tabs[currentTab].style.display = "block";

      if (currentTab === 0) {
        this.buttonPrev.style.visibility = "hidden";
      } else {
        this.buttonPrev.style.visibility = "visible";
      }

      if (currentTab === tabs.length - 1) {
        this.buttonNext.innerHTML = "Finalizar &#10003;";
      } else {
        this.buttonNext.innerHTML = "Continuar";
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
  }]);

  return ParticipanteController;
}();

/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (ParticipanteController);

/***/ }),

/***/ "./src/_javascript/domain/Cuidador/Cuidador.js":
/*!*****************************************************!*\
  !*** ./src/_javascript/domain/Cuidador/Cuidador.js ***!
  \*****************************************************/
/*! namespace exports */
/*! export default [provided] [no usage info] [missing usage info prevents renaming] */
/*! other exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_require__, __webpack_exports__, __webpack_require__.r, __webpack_require__.d, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "default": () => __WEBPACK_DEFAULT_EXPORT__
/* harmony export */ });
/* harmony import */ var _utils_masks__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../utils/masks */ "./src/_javascript/utils/masks.js");
function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }



var Cuidador = /*#__PURE__*/function () {
  function Cuidador() {
    _classCallCheck(this, Cuidador);

    var $ = document.querySelector.bind(document);
    this.nome = $("#nome-cuidador");
    this.cpf = $("#cpf-cuidador");
    this.dataNascimento = $("#nascimento-cuidador");
    this.email = $("#email-cuidador");
    this.genero = $("#genero-cuidador");
    this.estadoCivil = $("#estadocivil-cuidador");
    this.telefone = $("#telefone-cuidador");
    this.enderecoNumero = $("#numero-cuidador");
    this.complemento = $("#complemento-cuidador");
    this.cep = $("#cep-cuidador");
    this.rua = $("#rua-cuidador");
    this.bairro = $("#bairro-cuidador");
    this.cidade = $("#cidade-cuidador");
    this.estado = $("#estado-cuidador");
  }

  _createClass(Cuidador, [{
    key: "add",
    value: function add() {
      var cpfWithoutMask = _utils_masks__WEBPACK_IMPORTED_MODULE_0__.default.removeMask("cpf", this.cpf.value);
      var cepWithoutMask = _utils_masks__WEBPACK_IMPORTED_MODULE_0__.default.removeMask("cep", this.cep.value);
      var phoneWithoutMask = _utils_masks__WEBPACK_IMPORTED_MODULE_0__.default.removeMask("phone", this.telefone.value);
      var data = {
        nome: this.nome.value,
        cpf: cpfWithoutMask,
        dataNascimento: this.dataNascimento.value,
        email: this.email.value,
        genero: this.genero.value,
        estadoCivil: this.estadoCivil.value,
        telefone: [phoneWithoutMask],
        endereco: {
          numero: this.enderecoNumero.value,
          complemento: this.complemento.value,
          cep: cepWithoutMask,
          rua: {
            nome: this.rua.value,
            bairro: {
              nome: this.bairro.value,
              cidade: {
                nome: this.cidade.value,
                estado: {
                  nome: this.estado.value
                }
              }
            }
          }
        }
      };
      var self = this;
      $.ajax({
        type: "POST",
        url: "/api/cuidadores/",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function success(res) {
          var newState = new Option(res.nome, res.id, true, true);
          $("#cuidador").append(newState).trigger("change");
          document.querySelector(".modal-cuidador").style.display = "none";
        },
        error: function error(XMLHttpRequest, textStatus, errorThrown) {
          self.showErrors(XMLHttpRequest.responseJSON);
        }
      });
    }
  }, {
    key: "showErrors",
    value: function showErrors(data) {
      var inputErrors = data.campos;
      var notificationErrorsCuidador = document.querySelector("#noticacao-erros-cuidador");
      notificationErrorsCuidador.innerHTML = "";
      inputErrors.map(function (campo) {
        var line = "<div class=\"notification is-light is-danger\">\n              <p>".concat(campo.mensagem, "</p>\n          </div>");
        notificationErrorsCuidador.innerHTML += line;
      });
      notificationErrorsCuidador.scrollIntoView();
    }
  }]);

  return Cuidador;
}();

/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (Cuidador);

/***/ }),

/***/ "./src/_javascript/domain/Paciente/Paciente.js":
/*!*****************************************************!*\
  !*** ./src/_javascript/domain/Paciente/Paciente.js ***!
  \*****************************************************/
/*! namespace exports */
/*! export default [provided] [no usage info] [missing usage info prevents renaming] */
/*! other exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_require__, __webpack_exports__, __webpack_require__.r, __webpack_require__.d, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "default": () => __WEBPACK_DEFAULT_EXPORT__
/* harmony export */ });
/* harmony import */ var _utils_masks__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../utils/masks */ "./src/_javascript/utils/masks.js");
function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }



var Paciente = /*#__PURE__*/function () {
  function Paciente() {
    _classCallCheck(this, Paciente);

    var $ = document.querySelector.bind(document);
    this.nome = $("#nome-paciente");
    this.cpf = $("#cpf-paciente");
    this.dataNascimento = $("#nascimento-paciente");
    this.email = $("#email-paciente");
    this.genero = $("#genero-paciente");
    this.estadoCivil = $("#estadocivil-paciente");
    this.parkinson = $("#parkinson");
    this.alzheimer = $("#alzheimer");
    this.telefone = $("#telefone-paciente");
    this.enderecoNumero = $("#numero-paciente");
    this.complemento = $("#complemento-paciente");
    this.cep = $("#cep-paciente");
    this.rua = $("#rua-paciente");
    this.bairro = $("#bairro-paciente");
    this.cidade = $("#cidade-paciente");
    this.estado = $("#estado-paciente");
  }

  _createClass(Paciente, [{
    key: "add",
    value: function add() {
      var cpfWithoutMask = _utils_masks__WEBPACK_IMPORTED_MODULE_0__.default.removeMask("cpf", this.cpf.value);
      var cepWithoutMask = _utils_masks__WEBPACK_IMPORTED_MODULE_0__.default.removeMask("cep", this.cep.value);
      var phoneWithoutMask = _utils_masks__WEBPACK_IMPORTED_MODULE_0__.default.removeMask("phone", this.telefone.value);
      var data = {
        nome: this.nome.value,
        cpf: cpfWithoutMask,
        dataNascimento: this.dataNascimento.value,
        email: this.email.value,
        genero: this.genero.value,
        estadoCivil: this.estadoCivil.value,
        parkinson: this.parkinson.checked,
        alzheimer: this.alzheimer.checked,
        telefone: [phoneWithoutMask],
        endereco: {
          numero: this.enderecoNumero.value,
          complemento: this.complemento.value,
          cep: cepWithoutMask,
          rua: {
            nome: this.rua.value,
            bairro: {
              nome: this.bairro.value,
              cidade: {
                nome: this.cidade.value,
                estado: {
                  nome: this.estado.value
                }
              }
            }
          }
        }
      };
      var self = this;
      $.ajax({
        type: "POST",
        url: "/api/pacientes/",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function success(res) {
          console.log(res);
          var newState = new Option(res.nome, res.id, true, true);
          $("#paciente").append(newState).trigger("change");
          console.log(res);
          document.querySelector(".modal-paciente").style.display = "none";
        },
        error: function error(XMLHttpRequest, textStatus, errorThrown) {
          self.showErrors(XMLHttpRequest.responseJSON);
        }
      });
    }
  }, {
    key: "showErrors",
    value: function showErrors(data) {
      var inputErrors = data.campos;
      var notificationErrorsPaciente = document.querySelector("#noticacao-erros-paciente");
      notificationErrorsPaciente.innerHTML = "";
      inputErrors.map(function (campo) {
        var line = "<div class=\"notification is-light is-danger\">\n              <p>".concat(campo.mensagem, "</p>\n          </div>");
        notificationErrorsPaciente.innerHTML += line;
      });
      notificationErrorsPaciente.scrollIntoView();
    }
  }]);

  return Paciente;
}();

/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (Paciente);

/***/ }),

/***/ "./src/_javascript/utils/masks.js":
/*!****************************************!*\
  !*** ./src/_javascript/utils/masks.js ***!
  \****************************************/
/*! namespace exports */
/*! export default [provided] [no usage info] [missing usage info prevents renaming] */
/*! other exports [not provided] [no usage info] */
/*! runtime requirements: __webpack_exports__, __webpack_require__.r, __webpack_require__.d, __webpack_require__.* */
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "default": () => __WEBPACK_DEFAULT_EXPORT__
/* harmony export */ });
function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

var Mascaras = /*#__PURE__*/function () {
  function Mascaras() {
    _classCallCheck(this, Mascaras);
  }

  _createClass(Mascaras, null, [{
    key: "bind",
    value: function bind() {
      var masks = {
        data: function data(value) {
          return value.replace(/\D/g, "").replace(/(\d{2})(\d)/, "$1/$2").replace(/(\d{2})(\d)/, "$1/$2").replace(/(\/\d{4})\d+?$/, "$1");
        },
        cpf: function cpf(value) {
          return value.replace(/\D/g, "").replace(/(\d{3})(\d)/, "$1.$2").replace(/(\d{3})(\d)/, "$1.$2").replace(/(\d{3})(\d{1,2})/, "$1-$2").replace(/(-\d{2})\d+?$/, "$1");
        },
        phone: function phone(value) {
          return value.replace(/\D/g, "").replace(/(\d{2})(\d)/, "($1) $2").replace(/(\d{4})(\d)/, "$1-$2").replace(/(\d{4})-(\d)(\d{4})/, "$1$2-$3").replace(/(-\d{4})\d+?$/, "$1");
        },
        cep: function cep(value) {
          return value.replace(/\D/g, "").replace(/(\d{5})(\d)/, "$1-$2").replace(/(-\d{3})\d+?$/, "$1");
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
    }
  }, {
    key: "removeMask",
    value: function removeMask(mask, inputValue) {
      if (mask === "cpf") {
        var oneQuarter = inputValue.slice(0, 3);
        var twoQuarter = inputValue.slice(4, 7);
        var threeQuarter = inputValue.slice(8, 11);
        var fourQuarter = inputValue.slice(12);
        return "".concat(oneQuarter).concat(twoQuarter).concat(threeQuarter).concat(fourQuarter);
      }

      if (mask === "phone") {
        var ddd = inputValue.slice(1, 3);
        var number = inputValue.slice(5).replace("-", "");
        return "".concat(ddd).concat(number);
      }

      if (mask === "cep") {
        return inputValue.replace("-", "");
      }
    }
  }, {
    key: "addMask",
    value: function addMask(mask, value) {
      if (mask === "cpf") {
        var oneQuarter = value.slice(0, 3);
        var twoQuarter = value.slice(4, 7);
        var threeQuarter = value.slice(8, 11);
        var fourQuarter = value.slice(12);
        return "".concat(oneQuarter, ".").concat(twoQuarter, ".").concat(threeQuarter, "-").concat(fourQuarter);
      }

      if (mask === "phone") {
        var ddd = value.slice(1, 3);
        var number = value.slice(5);
        return "(".concat(ddd, ") ").concat(number);
      }

      if (mask === "cep") {
        return "".concat(value.slice(0, 4), "-").concat(value.slice(5));
      }
    }
  }]);

  return Mascaras;
}();

/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (Mascaras);

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
/* harmony import */ var _javascript_controllers_ParticipanteController__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./_javascript/controllers/ParticipanteController */ "./src/_javascript/controllers/ParticipanteController.js");
/* harmony import */ var _javascript_components_Notificacao__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./_javascript/components/Notificacao */ "./src/_javascript/components/Notificacao/index.js");
/* harmony import */ var _javascript_components_DetailsOptions__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./_javascript/components/DetailsOptions */ "./src/_javascript/components/DetailsOptions/index.js");
/* harmony import */ var _javascript_utils_masks__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./_javascript/utils/masks */ "./src/_javascript/utils/masks.js");
/* harmony import */ var _javascript_components_DataTablesListFilter__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./_javascript/components/DataTablesListFilter */ "./src/_javascript/components/DataTablesListFilter/index.js");
__webpack_require__(/*! ./_sass/main.scss */ "./src/_sass/main.scss");






document.addEventListener("DOMContentLoaded", function () {
  if (document.querySelector("[data-notification]")) {
    _javascript_components_Notificacao__WEBPACK_IMPORTED_MODULE_1__.default.bind();
  }

  if (document.querySelector(".detalhes-opcoes-botao")) {
    _javascript_components_DetailsOptions__WEBPACK_IMPORTED_MODULE_2__.default.bind();
  }

  if (document.querySelector(".button-cadastro-continuar")) {
    var participanteController = new _javascript_controllers_ParticipanteController__WEBPACK_IMPORTED_MODULE_0__.default();
    participanteController.bind();
    _javascript_utils_masks__WEBPACK_IMPORTED_MODULE_3__.default.bind();
  }

  if (document.querySelector("#chamadas,#pacientes,#cuidadores")) {
    _javascript_components_DataTablesListFilter__WEBPACK_IMPORTED_MODULE_4__.default.bind();
  }
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