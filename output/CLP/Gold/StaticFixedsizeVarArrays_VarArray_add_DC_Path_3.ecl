:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

solving_Path_3(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [Result_dim],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_102617125),
nth1(1,Self_dimensionSizes,Var_306980751),
((Var_306980751 #> 0),
(Var_102617125 #< 10)),
nth1(1,Arg_dimensionSizes,Var_363988129),
nth1(1,Self_dimensionSizes,Var_1997963191),
length(Arg_dimensionSizes,Var_769429195),
length(Self_dimensionSizes,Var_580718781),
((Var_580718781 #= Var_769429195),
(Var_1997963191 #= Var_363988129)),
nth1(1,Result_dimensionSizes,Var_1196695891),
nth1(1,Self_dimensionSizes,Var_867148091),
length(Result_dimensionSizes,Var_2051853139),
length(Self_dimensionSizes,Var_815674463),
((Var_815674463 #= Var_2051853139),
(Var_867148091 #= Var_1196695891)),
nth1(1,Arg_dimensionSizes,Var_1453774246),
(Dim1 = Var_1453774246),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_71587369),nth1(Idx0,List_71587369,Var_71587369),(It = Var_71587369),
getArrayElement(Arg_data,[It],Var_1169794610_1),getArrayElement(Self_data,[It],Var_634540230_1),getArrayElement(Result_data,[It],Var_1307904972_1),(Var_1307904972_1 #= (Var_634540230_1+Var_1169794610_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
