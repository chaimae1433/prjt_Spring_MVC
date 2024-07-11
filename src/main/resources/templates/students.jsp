<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="css/style.css">
  <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="Styles/main.css">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

  <script>
    $(document).ready(function(){
      // Activate tooltip
      $('[data-toggle="tooltip"]').tooltip();

      // Select/Deselect checkboxes
      var checkbox = $('table tbody input[type="checkbox"]');
      $("#selectAll").click(function(){
        if(this.checked){
          checkbox.each(function(){
            this.checked = true;
          });
        } else{
          checkbox.each(function(){
            this.checked = false);
          });
        }
      });
      checkbox.click(function(){
        if(!this.checked){
          $("#selectAll").prop("checked", false);
        }
      });
    });
  </script>
</head>
<body>
<div class="container-xl">
  <div class="table-responsive">
    <div class="table-wrapper">
      <div class="table-title">
        <div class="row">
          <div class="col-sm-6">
            <h2>${code}</h2>
          </div>
          <nav class="nav nav-pills nav-fill" style="margin-top: 20px;">
            <a class="nav-item nav-link active" href="index.jsp">home</a>
            <a class="nav-item nav-link btn" href="#addEmployeeModal" data-toggle="modal">Add New Eleve</a>
            <a class="nav-item nav-link" href="listerFilieres.action">Liste Filieres</a>
          </nav>
        </div>
      </div>
      <section class="ftco-section">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
              <h2 style="margin-top:20px;" class="heading-section"></h2>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <div class="table-wrap">
                <p>nombre d'etudiant non inscris a aucun filiere est ${nbnonafct} <a class="btn btn-outline-success" href='nonaffect' >voir</a></p>
                <table class="table">
                  <thead class="thead-primary">
                    <tr>
                      <th>#</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Email Address</th>
                      <th>moyenne</th>
                      <th>#</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="eleve" items="${eleves}">
                      <tr id="${eleve.cne}">
                        <td>
                          <span class="custom-checkbox">
                            <input type="checkbox" id="checkbox2" name="options[]" value="1">
                            <label for="checkbox2"></label>
                          </span>
                        </td>
                        <td>${eleve.cne}</td>
                        <td>${eleve.nom}</td>
                        <td>${eleve.prenom}</td>
                        <td>${eleve.moyenne}</td>
                        <td>${eleve.filiere.codeFil}</td>
                        <td>
                          <a onclick="editEleve('${eleve.cne}')" href="#editEmployeeModal" class="edit" data-toggle="modal" id="edit-btnn"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                          <a class="delete" onclick="if (!(confirm('Etes vous sur de vouloir supprimer cette Eleve ?'))) return false" title="Delete" data-toggle="tooltip" href="deleteEleve.action?code=${eleve.cne}"><i class="material-icons">&#xE872;</i></a>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </div>
</div>

<!-- Add Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="ajouterEleve">
        <div class="modal-header">
          <h4 class="modal-title">Add Eleve</h4>
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label>cne</label>
            <input type="text" class="form-control" required name="eleve.cne">
          </div>
          <div class="form-group">
            <label>Nom</label>
            <input type="text" class="form-control" required name="eleve.nom">
          </div>
          <div class="form-group">
            <label>Prenom</label>
            <input type="text" class="form-control" required name="eleve.prenom">
          </div>
          <div class="form-group">
            <label>Moyenne</label>
            <input type="text" class="form-control" required name="eleve.moyenne">
          </div>
          <div class="form-group">
            <label>Filiere</label>
            <select class="form-control" name="eleve.filiere.codeFil">
              <option value="">--Please choose an option--</option>
              <c:forEach var="filiere" items="${filieres}">
                <option value="${filiere.codeFil}">${filiere.codeFil}</option>
              </c:forEach>
            </select>
          </div>
        </div>
        <div class="modal-footer">
          <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
          <input type="submit" class="btn btn-success" value="Add">
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="updateEleve">
        <div class="modal-header">
          <h4 class="modal-title">Edit Eleve</h4>
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label>cne</label>
            <input id="edtCodIn" type="text" class="form-control" required name="eleve.cne" readonly="readonly">
          </div>
          <div class="form-group">
            <label>Nom</label>
            <input id="edtNomIn" type="text" class="form-control" required name="eleve.nom">
          </div>
          <div class="form-group">
            <label>Prenom</label>
            <input id="edtPrenomIn" type="text" class="form-control" required name="eleve.prenom">
          </div>
          <div class="form-group">
            <label>Moyenne</label>
            <input id="edtMoyenneIn" type="text" class="form-control" required name="eleve.moyenne">
          </div>
          <div class="form-group">
                        <label>Filiere</label>
                        <select class="form-control" id="edtFiliereIn" name="eleve.filiere.codeFil">
                          <option disabled>--Please choose an option--</option>
                          <c:forEach var="filiere" items="${filieres}">
                            <option value="${filiere.codeFil}">${filiere.codeFil}</option>
                          </c:forEach>
                        </select>
                      </div>
                    </div>
                    <div class="modal-footer">
                      <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                      <input type="submit" class="btn btn-success" value="UPDATE">
                    </div>
                  </form>
                </div>
              </div>
            </div>

            <script type="text/javascript">
              function editEleve(code) {
                let eleve = document.getElementById(code);
                console.log("article CLicked " + eleve.innerHTML);
                initEdtValue("edtCodIn", eleve, 2);
                initEdtValue("edtNomIn", eleve, 3);
                initEdtValue("edtPrenomIn", eleve, 4);
                initEdtValue("edtMoyenneIn", eleve, 5);
              }

              function initEdtValue(edtId, eleve, cellIdx) {
                document.getElementById(edtId).setAttribute("value", eleve.cells[cellIdx - 1].innerHTML);
              }
            </script>

            </body>
            </html>

