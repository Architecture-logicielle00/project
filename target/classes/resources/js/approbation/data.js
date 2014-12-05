/**
 * Created by David on 2014-11-24.
 */

function getData() {
    return fakeData;
}

function sendApproval(decision, approval){
	var approval.state = decision;
	
	//j_post("/departement/approbations",data, undefined, undefined, undefined);
}

function approval($el){
	sendApproval(true, fakeData.[])
}

function disapproval($el){
	sendApproval(false, {});
}

fakeData = [
    {
        name: "David",
        type: "deplacements",
        data: {
            date: "21-04-2014",
            distance: "6",
            coutKm: "5.79",
            description: "lorem ipsum color us fkw ffw e ehh os fhd"
        }
    s
    },
    {
        name: "Jean-Philippe",
        type: "depenses",
        data: {
            date: "2014-12-01",
            nbRepas: "4",
            coutRepas: "9.99",
            divers: "",
            coucher: "56.98",
            description: "lorem ipsum no dolor es ira de  io weha dhei kfbe  oabdhecbej"
        }
    },
    {
        name: "Alexandra",
        type: "feuilleDeTemps",
        data: {
            joursPeriode: [
                {
                    jourPeriode: "2014-11-24"
                },
                {
                    jourPeriode: "2014-11-25"
                },
                {
                    jourPeriode: "2014-11-26"
                },
                {
                    jourPeriode: "2014-11-27"
                },
                {
                    jourPeriode: "2014-11-28"
                },
                {
                    jourPeriode: "2014-11-29"
                },
                {
                    jourPeriode: "2014-11-30"
                }
            ],
            taches: [
                {
                    tache: "dormir",
                    heures: [
                        {
                            heure: 16
                        },
                        {
                            heure: 8
                        },
                        {
                            heure: 10
                        },
                        {
                            heure: 7
                        },
                        {
                            heure: 4
                        },
                        {
                            heure: 6
                        },
                        {
                            heure: 2
                        }

                    ]
                }
            ],
            commentaires: [
                {
                    commentaire: ""
                },
                {
                    commentaire: "fdssffsd"
                },
                {
                    commentaire: "dsfsdafdsaf"
                },
                {
                    commentaire: "fdsafsdafasd"
                },
                {
                    commentaire: ""
                },
                {
                    commentaire: ""
                },
                {
                    commentaire: ""
                }

            ]
        }
    }]

;


