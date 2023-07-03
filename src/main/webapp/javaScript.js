/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

PrimeFaces.locales['pt_BR'] = {
    closeText: 'Fechar',
    prevText: 'Anterior',
    nextText: 'Próximo',
    currentText: 'Começo',
    monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
    dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
    dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
    weekHeader: 'Semana',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Só Horas',
    timeText: 'Tempo',
    hourText: 'Hora',
    minuteText: 'Minuto',
    secondText: 'Segundo',
    ampm: false,
    month: 'Mês',
    week: 'Semana',
    day: 'Dia',
    allDayText: 'Todo Dia'
};

function ismobile()
{
    //alert("W >  "+screen.width); 
    //alert("H >  "+screen.height);
    //alert('botshdf');
    if (screen.width < 640 || screen.height < 480) {
        //mobile
        rcName([{name: 'model', value: 'detalhesm'}]);
    } else
    {
        rcName([{name: 'model', value: 'detalhes'}]);
    }
};

function topo() {
    window.scrollTo(0, 0);
};

function somenteNumeros(campo)
{
    campo.value = campo.value.replace(/\D/g, "");
};

function somenteFloat(campo)
{
    campo.value = campo.value.replace(/[A-Z]/i, "");
    campo.value = campo.value.replace(/[ -+*/&%$#@%!?]/g,"");
    campo.value = campo.value.replace(/[,]/g,".");
};

function somenteMaiuscula(campo)
{
    campo.value = campo.value.toUpperCase();
};

function formataPlaca(campo)
{
    campo.value = campo.value.toUpperCase();    
    campo.value = campo.value.replace(/[ -+*/&%$#@%!?]/g,"");
};

function fechar(pagina)
{
    window.close(pagina);   
};







