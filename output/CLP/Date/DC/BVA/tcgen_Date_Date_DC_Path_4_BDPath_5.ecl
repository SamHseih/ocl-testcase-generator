:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_Date_DC_Path_4_BDPath_5(Self,Y,M,D):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day, Y, M, D]#::(-32768)..32767,
%CLG Path Constrints,
(((((Y #> 1) , (M #> 1)) , (M #< 12)) , (D #> 1)) , (((((((((M #= 1) ; (M #= 3)) ; (M #= 5)) ; (M #= 7)) ; (M #= 8)) ; (M #= 10)) ; (M #= 12)),(D #=< 31));((((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),((((((M #= 4) ; (M #= 6)) ; (M #= 9)) ; (M #= 11)),(D #=< 30));(((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),((delay_mod(Y,100, Var_1076607567),
delay_mod(Y,4, Var_2036127838),
delay_mod(Y,400, Var_1509791656),
((Var_1509791656 #= 0) ; ((Var_2036127838 #= 0) , (Var_1076607567 #\= 0))),(D #< 30));(delay_mod(Y,100, Var_257608164),
delay_mod(Y,4, Var_306115458),
delay_mod(Y,100, Var_230643635),
delay_mod(Y,4, Var_944427387),
delay_mod(Y,400, Var_1636182655),
((Var_1636182655 #\= 0) , (((Var_944427387 #\= 0) , (Var_230643635 #\= 0)) ; ((Var_306115458 #= 0) , (Var_257608164 #= 0)))),(D #< 29)))))))),
(((((((M #\= 1) , (M #\= 3)) , (M #\= 5)) , (M #\= 7)) , (M #\= 8)) , (M #\= 10)) , (M #\= 12)),
((((M #\= 4) , (M #\= 6)) , (M #\= 9)) , (M #\= 11)),
delay_mod(Y,100, Var_71399214),
delay_mod(Y,4, Var_1932831450),
delay_mod(Y,400, Var_496729294),
((Var_496729294 #= 0) ; ((Var_1932831450 #= 0) , (Var_71399214 #\= 0))),
(D #< 30),
(((Self_year #= Y) , (Self_month #= M)) , (Self_day #= D)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day, Y, M, D]).
