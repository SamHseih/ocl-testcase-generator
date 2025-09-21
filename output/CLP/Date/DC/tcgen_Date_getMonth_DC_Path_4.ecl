:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getMonth_DC_Path_4(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_836220863),
delay_mod(Self_year,4, Var_1667148529),
delay_mod(Self_year,400, Var_1546693040),
((Var_1546693040 #= 0) ; ((Var_1667148529 #= 0) , (Var_836220863 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_825658265),
delay_mod(Self_year,4, Var_388357135),
delay_mod(Self_year,100, Var_957465255),
delay_mod(Self_year,4, Var_1254344205),
delay_mod(Self_year,400, Var_1336735375),
((Var_1336735375 #\= 0) , (((Var_1254344205 #\= 0) , (Var_957465255 #\= 0)) ; ((Var_388357135 #= 0) , (Var_825658265 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_836220863),
delay_mod(Self_year,4, Var_1667148529),
delay_mod(Self_year,400, Var_1546693040),
((Var_1546693040 #= 0) ; ((Var_1667148529 #= 0) , (Var_836220863 #\= 0))),
(Self_day #=< 29),
(Result #= Self_month),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
