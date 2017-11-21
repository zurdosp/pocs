#!/bin/bash
declare -A matrixservicos
num_rows=2
limite_quantidade_tentativas_antes_alarmar=3
segundos_sleep_lopp_checagem=1
qde_restart_com_falha_para_alarmar=3


#matrixservicos[x,0] -> nome do servico
#matrixservicos[x,1] -> endPoint ou scrip a executar
#matrixservicos[x,2] -> quantidade de incidentes de erro 
#matrixservicos[x,3] -> tipo de rotina a ser checada
#matrixservicos[x,4] -> qde restar com falha  .TODO
#matrixservicos[x,5] -> comando restart	      .TODO


matrixservicos[0,0]="servico1"
matrixservicos[0,1]="http://localhost:9999/students/1111"
matrixservicos[0,2]=0
matrixservicos[0,3]="rest"

matrixservicos[1,0]="servico2"
matrixservicos[1,1]="http://localhost:9999/students/1111"
matrixservicos[1,2]=0
matrixservicos[1,3]="rest"


declare -A listaNomesServicos

mandaEmail(){  # TODO
        echo "manda email"
}


while true; do
	for (( i=0; i<num_rows; i++ )) do
		if [ ${matrixservicos[$i,3]} == "rest" ]; then
			retorno=$(curl -o /dev/null --silent --head --write-out '%{http_code}\n' ${matrixservicos[$i,1]})
			if [ "$retorno" != 200 ]; then
				if [ ${matrixservicos[$i,2]} == 3 ]; then
	                		mandaEmail
					matrixservicos[$i,2]=0;
				fi
				matrixservicos[$i,2]=$((${matrixservicos[$i,2]}+1))
				echo 'falha'
			else
				echo 'ok'
				matrixservicos[$i,2]=0
	        	fi
		fi
		if [ ${matrixservicos[$i,3]} == "mongo" ]; then
			echo "validando mongo"
			matrixservicos[$i,2]=0 #sucesso
			# matrixservicos[$i,2]=$((${matrixservicos[$i,2]}+1))  # falha

		fi

	done
	sleep $segundos_sleep_lopp_checagem
done

