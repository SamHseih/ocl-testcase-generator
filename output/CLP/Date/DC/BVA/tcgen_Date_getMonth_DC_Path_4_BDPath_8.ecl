:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getMonth_DC_Path_4_BDPath_8(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2095064787),
delay_mod(Self_year,4, Var_2095486832),
delay_mod(Self_year,400, Var_391183339),
((Var_391183339 #= 0) ; ((Var_2095486832 #= 0) , (Var_2095064787 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1529115495),
delay_mod(Self_year,4, Var_646910062),
delay_mod(Self_year,100, Var_1855610584),
delay_mod(Self_year,4, Var_2114289475),
delay_mod(Self_year,400, Var_113411247),
((Var_113411247 #\= 0) , (((Var_2114289475 #\= 0) , (Var_1855610584 #\= 0)) ; ((Var_646910062 #= 0) , (Var_1529115495 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_1485891705),
delay_mod(Self_year,4, Var_1681920301),
delay_mod(Self_year,400, Var_837457281),
((Var_837457281 #= 0) ; ((Var_1681920301 #= 0) , (Var_1485891705 #\= 0))),
(Self_day #=< 29),
(Result #= Self_month),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
