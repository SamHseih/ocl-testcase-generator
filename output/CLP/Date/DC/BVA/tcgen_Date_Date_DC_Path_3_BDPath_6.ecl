:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DC_Path_3_BDPath_6(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day, Y, M, D]#::(-32768)..32767,
%CLG Path Constrints,
(((((Y #> 1) , (M #> 1)) , (M #< 12)) , (D #> 1)) , (((((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),(D #=< 31));((((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),((((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),(D #=< 30));(((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),((delay_mod(Y,100, Var_367746789),
delay_mod(Y,4, Var_558216562),
delay_mod(Y,400, Var_961712517),
((Var_961712517 #= 0) ; ((Var_558216562 #= 0) , (Var_367746789 #\= 0))),(D #< 30));(delay_mod(Y,100, Var_1928931046),
delay_mod(Y,4, Var_1034568234),
delay_mod(Y,100, Var_835227336),
delay_mod(Y,4, Var_482082765),
delay_mod(Y,400, Var_667821226),
((Var_667821226 #\= 0) , (((Var_482082765 #\= 0) , (Var_835227336 #\= 0)) ; ((Var_1034568234 #= 0) , (Var_1928931046 #= 0)))),(D #< 29)))))))),
(((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),
((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),
(D #< 30),
(((Self_year #= Y) , (Self_month #= M)) , (Self_day #= D)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
