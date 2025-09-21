:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getMonth_DC_Path_3_BDPath_4(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1522095831),
delay_mod(Self_year,4, Var_910599202),
delay_mod(Self_year,400, Var_1963862935),
((Var_1963862935 #= 0) ; ((Var_910599202 #= 0) , (Var_1522095831 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1042786867),
delay_mod(Self_year,4, Var_775445710),
delay_mod(Self_year,100, Var_769432223),
delay_mod(Self_year,4, Var_696933920),
delay_mod(Self_year,400, Var_712974096),
((Var_712974096 #\= 0) , (((Var_696933920 #\= 0) , (Var_769432223 #\= 0)) ; ((Var_775445710 #= 0) , (Var_1042786867 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),
(Self_day #=< 30),
(Result #= Self_month),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
