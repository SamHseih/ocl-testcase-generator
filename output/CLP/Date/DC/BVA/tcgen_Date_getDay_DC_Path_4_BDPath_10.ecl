:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_4_BDPath_10(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)),
(((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_644052207),
delay_mod(Self_year,4, Var_330551672),
delay_mod(Self_year,400, Var_616881582),
((Var_616881582 #= 0) ; ((Var_330551672 #= 0) , (Var_644052207 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_939199469),
delay_mod(Self_year,4, Var_176342513),
delay_mod(Self_year,100, Var_129498568),
delay_mod(Self_year,4, Var_85748029),
delay_mod(Self_year,400, Var_1784131088),
((Var_1784131088 #\= 0) , (((Var_85748029 #\= 0) , (Var_129498568 #\= 0)) ; ((Var_176342513 #= 0) , (Var_939199469 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_1986417638),
delay_mod(Self_year,4, Var_1309129055),
delay_mod(Self_year,400, Var_682910755),
((Var_682910755 #= 0) ; ((Var_1309129055 #= 0) , (Var_1986417638 #\= 0))),
(Self_day #< 29),
(Result #= Self_day),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
