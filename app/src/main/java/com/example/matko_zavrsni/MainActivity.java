package com.example.matko_zavrsni;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.utils.HyperSpline;
import androidx.core.content.ContextCompat;


import com.google.android.material.textfield.TextInputLayout;

import javax.xml.transform.Result;


public class MainActivity extends AppCompatActivity {
    EditText presjekVodicaUnos, promjerVodicaUnos, masaVodicaUnos, koefToplinskogIstezanjaUnos, faktorNormDodatnogTeretaUnos, moduleElasticnostiUnos,
            normalnoDozvoljenoNaprezanjeUnos, iznimnoDozvoljenoNaprezanjeUnos, maksimalnoNaprezanjeUnos, rasponStupovaUnos, denivelacijaUnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presjekVodicaUnos = (EditText) findViewById(R.id.et_PresjekVodiča);
        promjerVodicaUnos = (EditText) findViewById(R.id.et_PromjerVodiča);
        masaVodicaUnos = (EditText) findViewById(R.id.et_LinijskaMasaVodiča);
        koefToplinskogIstezanjaUnos = (EditText) findViewById(R.id.et_koefToplinskogIstezanja);
        faktorNormDodatnogTeretaUnos = (EditText) findViewById(R.id.et_faktorNormDodatnogTereta);
        moduleElasticnostiUnos = (EditText) findViewById(R.id.et_ModulElastičnosti);
        normalnoDozvoljenoNaprezanjeUnos = (EditText) findViewById(R.id.et_NormDozvoljenoNaprezanje);
        iznimnoDozvoljenoNaprezanjeUnos = (EditText) findViewById(R.id.et_IznimnoDozvoljenoNaprezanje);
        maksimalnoNaprezanjeUnos = (EditText) findViewById(R.id.et_MaksimalnoNaprezanje);
        rasponStupovaUnos = (EditText) findViewById(R.id.et_RasponStupova);
        denivelacijaUnos = (EditText) findViewById(R.id.et_Denivelacija);



    }






    public void mybutton(View v) {

        class Cubic
        {



            private static final double TWO_PI = 2.0 * Math.PI;
            private static final double FOUR_PI = 4.0 * Math.PI;

            public int nRoots;
            public double x1;
            public double x2;
            public double x3;


            public Cubic()
            {
            }


            public void solve
            (double a,
             double b,
             double c,
             double d)
            {
                double denom = a;
                a = b/denom;
                b = c/denom;
                c = d/denom;


                double a_over_3 = a / 3.0;
                double Q = (3*b - a*a) / 9.0;
                double Q_CUBE = Q*Q*Q;
                double R = (9*a*b - 27*c - 2*a*a*a) / 54.0;
                double R_SQR = R*R;
                double D = Q_CUBE + R_SQR;

                if (D < 0.0)
                {
                    nRoots = 3;
                    double theta = Math.acos (R / Math.sqrt (-Q_CUBE));
                    double SQRT_Q = Math.sqrt (-Q);
                    x1 = 2.0 * SQRT_Q * Math.cos (theta/3.0) - a_over_3;
                    x2 = 2.0 * SQRT_Q * Math.cos ((theta+TWO_PI)/3.0) - a_over_3;
                    x3 = 2.0 * SQRT_Q * Math.cos ((theta+FOUR_PI)/3.0) - a_over_3;
                    sortRoots();
                }
                else if (D > 0.0)
                {

                    nRoots = 1;
                    double SQRT_D = Math.sqrt (D);
                    double S = Math.cbrt (R + SQRT_D);
                    double T = Math.cbrt (R - SQRT_D);
                    x1 = (S + T) - a_over_3;
                    x2 = Double.NaN;
                    x3 = Double.NaN;
                }
                else
                {

                    nRoots = 3;
                    double CBRT_R = Math.cbrt (R);
                    x1 = 2*CBRT_R - a_over_3;
                    x2 = x3 = CBRT_R - a_over_3;
                    sortRoots();
                }
            }

            private void sortRoots()
            {
                if (x1 < x2)
                {
                    double tmp = x1; x1 = x2; x2 = tmp;
                }
                if (x2 < x3)
                {
                    double tmp = x2; x2 = x3; x3 = tmp;
                }
                if (x1 < x2)
                {
                    double tmp = x1; x1 = x2; x2 = tmp;
                }
            }

            public void main
            (String[] args)
                    throws Exception
            {
                if (args.length != 4) usage();
                double a = Double.parseDouble (args[0]);
                double b = Double.parseDouble (args[1]);
                double c = Double.parseDouble (args[2]);
                double d = Double.parseDouble (args[3]);
                Cubic cubic = new Cubic();
                cubic.solve (a, b, c, d);
                System.out.println ("x1 = " + cubic.x1);
                if (cubic.nRoots == 3)
                {
                    System.out.println ("x2 = " + cubic.x2);
                    System.out.println ("x3 = " + cubic.x3);
                }
            }

            private void usage()
            {
                System.err.println ("Usage: java edu.rit.numeric.Cubic <a> <b> <c> <d>");
                System.err.println ("Solves ax^3 + bx^2 + cx + d = 0");
                System.exit (1);
            }

        }


        if (presjekVodicaUnos.getText().toString().equals("")
                || promjerVodicaUnos.getText().toString().equals("")
                || masaVodicaUnos.getText().toString().equals("")
                || koefToplinskogIstezanjaUnos.getText().toString().equals("")
                || faktorNormDodatnogTeretaUnos.getText().toString().equals("")
                || moduleElasticnostiUnos.getText().toString().equals("")
                || normalnoDozvoljenoNaprezanjeUnos.getText().toString().equals("")
                || iznimnoDozvoljenoNaprezanjeUnos.getText().toString().equals("")
                || maksimalnoNaprezanjeUnos.getText().toString().equals("")
                || rasponStupovaUnos.getText().toString().equals("")
                || denivelacijaUnos.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Potrebno je ispuniti sva polja",
                    Toast.LENGTH_SHORT).show();
        } else {
            Double presjek = Double.parseDouble(presjekVodicaUnos.getText().toString());
            Double promjer = Double.parseDouble(promjerVodicaUnos.getText().toString());
            Double masa = Double.parseDouble(masaVodicaUnos.getText().toString());
            Double koefIstezanja = Double.parseDouble(koefToplinskogIstezanjaUnos.getText().toString());
            Double faktorDodatnogTereta =
                    Double.parseDouble(faktorNormDodatnogTeretaUnos.getText().toString());
            Double modulElasticnosti = Double.parseDouble(moduleElasticnostiUnos.getText().toString());
            Double normalnoNaprezanje = Double.parseDouble(normalnoDozvoljenoNaprezanjeUnos.getText().toString());
            Double iznimnoNaprezanje = Double.parseDouble(iznimnoDozvoljenoNaprezanjeUnos.getText().toString());
            Double maksimalnoNaprezanje = Double.parseDouble(maksimalnoNaprezanjeUnos.getText().toString());
            Double rasponStupova = Double.parseDouble(rasponStupovaUnos.getText().toString());
            Double denivelacija = Double.parseDouble(denivelacijaUnos.getText().toString());
            if (presjek == 0
                    || promjer == 0
                    || masa == 0
                    || koefIstezanja == 0
                    || faktorDodatnogTereta == 0
                    || modulElasticnosti == 0
                    || normalnoNaprezanje == 0
                    || iznimnoNaprezanje == 0
                    || maksimalnoNaprezanje == 0
                    || rasponStupova == 0) {
                Toast.makeText(MainActivity.this, "Vrijednosti moraju biti veće od 0",

                        Toast.LENGTH_SHORT).show();
            } else {
                Double directDistance = Math.sqrt(Math.pow(denivelacija, 2) + Math.pow(rasponStupova, 2));
                Double reducedWeight = masa * 9.81 / presjek;
                Double reducedWeightOfIce = (faktorDodatnogTereta * 0.18 * Math.sqrt(promjer) * 9.81) /
                        presjek;
                Double reducedConductorWeight = reducedWeight + reducedWeightOfIce;
                Double criticalSpan = maksimalnoNaprezanje * Math.sqrt((360 * koefIstezanja)
                        / (Math.pow(reducedConductorWeight, 2) - Math.pow(reducedWeight, 2)));
                Double idealSpan = Math.sqrt((Math.pow(rasponStupova, 3) / (Math.pow(directDistance, 2) /
                        rasponStupova)))
                        * ((Math.pow(directDistance, 3) / Math.pow(rasponStupova, 2)) / (Math.pow(directDistance, 2) /
                        rasponStupova));
                Double strain = maksimalnoNaprezanje * ((Math.pow(directDistance, 3) / Math.pow(rasponStupova, 2)) /
                        (Math.pow(directDistance, 2) / rasponStupova));
                if (idealSpan > criticalSpan) {
                    Double temperature = -5.0;
                    Double secCo1 = -(strain - (((Math.pow(idealSpan, 2) / 24) *
                            (Math.pow(reducedConductorWeight, 2)
                                    / Math.pow(strain, 2)) - (koefIstezanja * (temperature - (-20)))) *
                            modulElasticnosti));
                    Double secCo2 = -(strain - (((Math.pow(idealSpan, 2) / 24) *
                            (Math.pow(reducedConductorWeight, 2)
                                    / Math.pow(strain, 2)) - (koefIstezanja * (temperature - (-5)))) * modulElasticnosti));
                    Double secCo3 = -(strain - (((Math.pow(idealSpan, 2) / 24) *
                            (Math.pow(reducedConductorWeight, 2)
                                    / Math.pow(strain, 2)) - (koefIstezanja * (temperature - 40))) * modulElasticnosti));
                    Double thirdCo1 = -((Math.pow(idealSpan, 2) * Math.pow(reducedWeight, 2)) / 24) *
                            modulElasticnosti;
                    Double thirdCo2 = -((Math.pow(idealSpan, 2) * Math.pow(reducedConductorWeight, 2)) / 24) * modulElasticnosti;
                    Double thirdCo3 = -((Math.pow(idealSpan, 2) * Math.pow(reducedWeight, 2)) / 24) *
                            modulElasticnosti;
                    Cubic cub = new Cubic();
                    cub.solve(1.0, secCo1, 0.0, thirdCo1);
                    Double strainRaw1 = cub.x1;
                    Cubic cub2 = new Cubic();
                    cub2.solve(1.0, secCo2, 0.0, thirdCo2);
                    Double strainRaw2 = cub2.x1;
                    Cubic cub3 = new Cubic();
                    cub3.solve(1.0, secCo3, 0.0, thirdCo3);
                    Double strainRaw3 = cub3.x1;
                    Double strain20 = strainRaw1 * ((Math.pow(directDistance, 2) / idealSpan) /
                            ((Math.pow(directDistance, 3) / Math.pow(idealSpan, 2))));
                    Double provjes20 = ((Math.pow(idealSpan, 2) * reducedWeight) / (8 * strain20)) *
                            (directDistance / idealSpan);
                    Double strain5 = strainRaw2 * ((Math.pow(directDistance, 2) / idealSpan) /
                            ((Math.pow(directDistance, 3) / Math.pow(idealSpan, 2))));
                    Double provjes5 = ((Math.pow(idealSpan, 2) * reducedConductorWeight) / (8 * strain5)) *
                            (directDistance / idealSpan);
                    Double strain40 = strainRaw3 * ((Math.pow(directDistance, 2) / idealSpan) /
                            ((Math.pow(directDistance, 3) / Math.pow(idealSpan, 2))));
                    Double provjes40 = ((Math.pow(idealSpan, 2) * reducedWeight) / (8 * strain40)) *
                            (directDistance / idealSpan);

                    Log.d("provjes40", String.valueOf((provjes40)));

                    Intent intent = new Intent(MainActivity.this, Results.class);
                    /*Bundle a = new Bundle();
                    a.putDouble("provjes", provjes20);

                    a.putDouble("provjes1", provjes5);
                    a.putDouble("provjes2", provjes40);
                    intent.putExtras(a);
                    startActivity(intent);*/
                    intent.putExtra("provjes",provjes20);
                    intent.putExtra("provjes1",provjes5);
                    intent.putExtra("provjes2",provjes40);
                    startActivity(intent);
                } else {
                    Double temperature = -20.0;
                    Double secCo1 = -(strain - (((Math.pow(idealSpan, 2) / 24) *
                            (Math.pow(reducedConductorWeight, 2) / Math.pow(strain, 2)) - (koefIstezanja * (temperature - (-
                            20)))) * modulElasticnosti));
                    Double secCo2 = -(strain - (((Math.pow(idealSpan, 2) / 24) *
                            (Math.pow(reducedConductorWeight, 2) / Math.pow(strain, 2)) - (koefIstezanja * (temperature - (-
                            5)))) * modulElasticnosti));
                    Double secCo3 = -(strain - (((Math.pow(idealSpan, 2) / 24) *
                            (Math.pow(reducedConductorWeight, 2) / Math.pow(strain, 2)) - (koefIstezanja * (temperature -
                            40))) * modulElasticnosti));
                    Double thirdCo1 = -((Math.pow(idealSpan, 2) * Math.pow(reducedWeight, 2)) / 24) *
                            modulElasticnosti;
                    Double thirdCo2 = -((Math.pow(idealSpan, 2) * Math.pow(reducedConductorWeight, 2)) /
                            24) * modulElasticnosti;
                    Double thirdCo3 = -((Math.pow(idealSpan, 2) * Math.pow(reducedWeight, 2)) / 24) *
                            modulElasticnosti;
                    Cubic cub = new Cubic();
                    cub.solve(1.0, secCo1, 0.0, thirdCo1);
                    Double strainRaw1 = cub.x1;
                    Cubic cub2 = new Cubic();
                    cub2.solve(1.0, secCo2, 0.0, thirdCo2);
                    Double strainRaw2 = cub2.x1;
                    Cubic cub3 = new Cubic();
                    cub3.solve(1.0, secCo3, 0.0, thirdCo3);
                    Double strainRaw3 = cub3.x1;

                    Double strain20 = strainRaw1 * ((Math.pow(directDistance, 2) / idealSpan) /
                            ((Math.pow(directDistance, 3) / Math.pow(idealSpan, 2))));
                    Double provjes20 = ((Math.pow(idealSpan, 2) * reducedWeight) / (8 * strain20)) *
                            (directDistance / idealSpan);
                    Double strain5 = strainRaw2 * ((Math.pow(directDistance, 2) / idealSpan) /
                            ((Math.pow(directDistance, 3) / Math.pow(idealSpan, 2))));
                    Double provjes5 = ((Math.pow(idealSpan, 2) * reducedConductorWeight) / (8 * strain5)) *
                            (directDistance / idealSpan);
                    Double strain40 = strainRaw3 * ((Math.pow(directDistance, 2) / idealSpan) /
                            ((Math.pow(directDistance, 3) / Math.pow(idealSpan, 2))));
                    Double provjes40 = ((Math.pow(idealSpan, 2) * reducedWeight) / (8 * strain40)) *
                            (directDistance / idealSpan);
                    Intent intent = new Intent(MainActivity.this, Results.class);
                    /*Bundle a = new Bundle();
                    a.putDouble("provjes", provjes20);
                    a.putDouble("provjes1", provjes5);
                    a.putDouble("provjes2", provjes40);
                    intent.putExtras(a);
                    startActivity(intent);*/
                    intent.putExtra("provjes",provjes20);
                    intent.putExtra("provjes1",provjes5);
                    intent.putExtra("provjes2",provjes40);
                    startActivity(intent);

                }
            }
        }
    }
}





