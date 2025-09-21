:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DC_Path_3_BDPath_5(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day, Y, M, D]#::(-32768)..32767,
%CLG Path Constrints,
(((((Y #>= 1) , (M #>= 1)) , (M #=< 12)) , (D #>= 1)) , (((((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),(D #=< 31));((((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),((((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),(D #=< 30));(((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),((delay_mod(Y,100, Var_957465255),
delay_mod(Y,4, Var_1254344205),
delay_mod(Y,400, Var_1336735375),
((Var_1336735375 #= 0) ; ((Var_1254344205 #= 0) , (Var_957465255 #\= 0))),(D #< 30));(delay_mod(Y,100, Var_1984990929),
delay_mod(Y,4, Var_1105423942),
delay_mod(Y,100, Var_365181913),
delay_mod(Y,4, Var_1031061344),
delay_mod(Y,400, Var_1327536153),
((Var_1327536153 #\= 0) , (((Var_1031061344 #\= 0) , (Var_365181913 #\= 0)) ; ((Var_1105423942 #= 0) , (Var_1984990929 #= 0)))),(D #< 29)))))))),
(((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),
((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),
(D #= 30),
(((Self_year #= Y) , (Self_month #= M)) , (Self_day #= D)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
