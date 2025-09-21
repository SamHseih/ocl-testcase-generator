:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_4(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2095303566),
delay_mod(Self_year,4, Var_2025221430),
delay_mod(Self_year,400, Var_1378084334),
((Var_1378084334 #= 0) ; ((Var_2025221430 #= 0) , (Var_2095303566 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1990160809),
delay_mod(Self_year,4, Var_1285524499),
delay_mod(Self_year,100, Var_1524960486),
delay_mod(Self_year,4, Var_117009527),
delay_mod(Self_year,400, Var_199640888),
((Var_199640888 #\= 0) , (((Var_117009527 #\= 0) , (Var_1524960486 #\= 0)) ; ((Var_1285524499 #= 0) , (Var_1990160809 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_2095303566),
delay_mod(Self_year,4, Var_2025221430),
delay_mod(Self_year,400, Var_1378084334),
((Var_1378084334 #= 0) ; ((Var_2025221430 #= 0) , (Var_2095303566 #\= 0))),
(Self_day #=< 29),
(Result #= Self_year),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
