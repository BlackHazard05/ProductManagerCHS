/**
 * 
 */

//Variables globales ///
cPrev = -1; //Variable para almacenar la columna que estamos ordenando

/////

function buscarMarca() {
	window.location = "buscarPorMarca/" + document.getElementById('marca').value;
}

function buscarPrecioMayor() {
	window.location = "buscarPorPrecio/" + document.getElementById('precio').value;
}

function myFunction() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[1];
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}

function sortBy(c) {
    rows = document.getElementById("myTable").rows.length; // numero de filas
    columns = document.getElementById("myTable").rows[0].cells.length; // num columnas
    arrTable = [...Array(rows)].map(e => Array(columns)); // Creamos un arreglo vacio

    for (ro=0; ro<rows; ro++) { // usamos un for a través de las filas
        for (co=0; co<columns; co++) { // ahora através de las columnas
            // asignamos el valor de cada fila-columna al segundo arreglo por fila-columna
            arrTable[ro][co] = document.getElementById("myTable").rows[ro].cells[co].innerHTML;
        }
    }

    th = arrTable.shift(); 
    
    if (c !== cPrev) { // Si una columna diferente es clickeada, filtramos la nueva columna
        arrTable.sort(
            function (a, b) {
                if (a[c] === b[c]) {
                    return 0;
                } else {
                    return (a[c] < b[c]) ? -1 : 1;
                }
            }
        );
    } else { // si la misma columna es clickeada, invertimos
        arrTable.reverse();
    }
    
    cPrev = c; // guardamos en nuestra variable global

    arrTable.unshift(th); 

    for (ro=0; ro<rows; ro++) {
        for (co=0; co<columns; co++) {
            document.getElementById("myTable").rows[ro].cells[co].innerHTML = arrTable[ro][co];
        }
    }
}