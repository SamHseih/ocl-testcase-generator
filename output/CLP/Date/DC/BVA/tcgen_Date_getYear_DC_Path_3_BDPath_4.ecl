:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_3_BDPath_4(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1603198149),
delay_mod(Self_year,4, Var_2063763486),
delay_mod(Self_year,400, Var_515715487),
((Var_515715487 #= 0) ; ((Var_2063763486 #= 0) , (Var_1603198149 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1007412025),
delay_mod(Self_year,4, Var_365590665),
delay_mod(Self_year,100, Var_2053591126),
delay_mod(Self_year,4, Var_220309324),
delay_mod(Self_year,400, Var_1850777594),
((Var_1850777594 #\= 0) , (((Var_220309324 #\= 0) , (Var_2053591126 #\= 0)) ; ((Var_365590665 #= 0) , (Var_1007412025 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),
(Self_day #=< 30),
(Result #= Self_year),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
